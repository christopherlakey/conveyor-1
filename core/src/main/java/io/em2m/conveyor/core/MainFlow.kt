package io.em2m.conveyor.core

import java.util.*

abstract class MainFlow<T>(override final val transformers: MutableList<Transformer<T>> = ArrayList())
    : Flow<T>, TransformerSupport<T>(Priorities.MAIN) {

    init {
        @Suppress("LeakingThis")
        transformers.add(this)
    }

}
