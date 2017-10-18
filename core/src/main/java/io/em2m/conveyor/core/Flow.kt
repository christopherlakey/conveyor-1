package io.em2m.conveyor.core

interface Flow<T> {

    val transformers: List<Transformer<T>>

}
