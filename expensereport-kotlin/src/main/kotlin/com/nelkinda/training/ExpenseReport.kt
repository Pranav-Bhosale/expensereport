package com.nelkinda.training

import java.util.*

enum class ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

data class Expense(
    var type: ExpenseType,
    var amount: Int = 0
)

class ExpenseReport {

    private val defaultPrinter = { str: String -> println(str) }

    fun printReport(expenses: List<Expense>, printer: (String) -> Unit = defaultPrinter) {
        var total = 0
        var mealExpenses = 0

        printer("Expenses ${Date()}")

        for (expense in expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount
            }

            var expenseName = ""
            when (expense.type) {
                ExpenseType.DINNER -> expenseName = "Dinner"
                ExpenseType.BREAKFAST -> expenseName = "Breakfast"
                ExpenseType.CAR_RENTAL -> expenseName = "Car Rental"
            }

            val mealOverExpensesMarker =
                if (expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000) "X" else " "

            printer(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker)

            total += expense.amount
        }

        printer("Meal expenses: $mealExpenses")
        printer("Total expenses: $total")
    }
}
