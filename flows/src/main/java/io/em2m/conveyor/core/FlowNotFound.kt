package io.em2m.conveyor.core

class FlowNotFound(val name: String) : Exception("Flow '$name' not found")