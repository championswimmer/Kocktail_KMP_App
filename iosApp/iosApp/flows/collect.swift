//
// Created by Arnav Gupta on 09/03/23.
// Copyright (c) 2023 orgName. All rights reserved.
//
import Combine
import Foundation
import shared

typealias OnEach<Output> = (Output) -> Void
typealias OnCompletion<Failure> = (Failure?) -> Void

typealias OnCollect<Output, Failure> = (@escaping OnEach<Output>, @escaping OnCompletion<Failure>) -> shared.Cancellable

/**
 Creates a `Publisher` that collects output from a flow wrapper function emitting values from an underlying
 instance of `Flow<T>`.
 */
func collect<Output, Failure>(_ onCollect: @escaping OnCollect<Output, Failure>) -> Publishers.Flow<Output, Failure> {
    return Publishers.Flow(onCollect: onCollect)
}

typealias OnCollect1<T1, Output, Failure> = (T1, @escaping OnEach<Output>, @escaping OnCompletion<Failure>) -> shared.Cancellable

/**
 Creates a `Publisher` that collects output from a flow wrapper function emitting values from an underlying
 instance of `Flow<T>`.
 */
func collect<T1, Output, Failure>(_ onCollect: @escaping OnCollect1<T1, Output, Failure>, with arg1: T1) -> Publishers.Flow<Output, Failure> {
    return Publishers.Flow { onCollect(arg1, $0, $1) }
}

/**
 Wraps a KMM `Cancellable` in a Combine `Subscription`
 */
class SharedCancellableSubscription: Subscription {
    private var isCancelled: Bool = false

    var cancellable: shared.Cancellable? {
        didSet {
            if isCancelled {
                cancellable?.cancel()
            }
        }
    }

    func request(_ demand: Subscribers.Demand) {
        // Not supported
    }

    func cancel() {
        isCancelled = true
        cancellable?.cancel()
    }
}

extension Publishers {
    class Flow<Output, Failure: Error>: Publisher {
        private let onCollect: OnCollect<Output, Failure>

        init(onCollect: @escaping OnCollect<Output, Failure>) {
            self.onCollect = onCollect
        }

        func receive<S>(subscriber: S) where S: Subscriber, Failure == S.Failure, Output == S.Input {
            let subscription = SharedCancellableSubscription()
            subscriber.receive(subscription: subscription)

            let cancellable = onCollect({ input in _ = subscriber.receive(input) }) { failure in
                if let failure = failure {
                    subscriber.receive(completion: .failure(failure))
                } else {
                    subscriber.receive(completion: .finished)
                }
            }

            subscription.cancellable = cancellable
        }
    }
}
