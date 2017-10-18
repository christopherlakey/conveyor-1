package io.em2m.conveyor.core


interface FlowResolver<T> {

    fun findFlow(key: String): Flow<T>?

}