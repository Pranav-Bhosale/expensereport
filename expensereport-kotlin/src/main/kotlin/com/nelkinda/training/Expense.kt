package com.nelkinda.training


class Expense(
    private val type: ExpenseType,
    private val amount: Int = 0
) {
    fun getIfMealOverExpenseMarker(): String {
        return if (type == ExpenseType.DINNER && amount > 5000 || type == ExpenseType.BREAKFAST && amount > 1000) "X" else " "
    }

    fun getExpenseName(): String {
        val expenseName: String = when (type) {
            ExpenseType.DINNER -> "Dinner"
            ExpenseType.BREAKFAST -> "Breakfast"
            ExpenseType.CAR_RENTAL -> "Car Rental"
        }
        return expenseName
    }

    fun getExpenseType(): ExpenseType {
        return type
    }

    fun getExpenseAmount(): Int {
        return amount
    }

}