package io.em2m.simplex.model


data class Condition(val op: String, val key: String, val value: List<String>)

interface ConditionHandler {
    fun test(keyValue: Any?, conditionValue: Any?): Boolean
}

interface ConditionResolver {
    fun getCondition(condition: String): ConditionHandler?
}

class BasicConditionResolver(val conditions: Map<String, ConditionHandler>) : ConditionResolver {
    override fun getCondition(condition: String): ConditionHandler? {
        return conditions[condition]
    }
}

class ConditionExpr(val condition: String, val handler: ConditionHandler, val first: Expr, val second: Expr) {

    fun call(context: ExprContext): Boolean {

        val firstVal = first.call(context)
        val secondVal = second.call(context)

        return handler.test(first, second)
    }

}