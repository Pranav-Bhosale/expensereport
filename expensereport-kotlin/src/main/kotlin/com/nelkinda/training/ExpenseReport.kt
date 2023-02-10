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
            mealExpenses = calculateMealExpense(expense, mealExpenses)

            printExpenseReport(expense, printer)

            total = calculateTotalExpense(total, expense)
        }

        printer("Meal expenses: $mealExpenses")
        printer("Total expenses: $total")
    }

    private fun printExpenseReport(expense: Expense, printer: (String) -> Unit) {
        val expenseName: String = getExpenseName(expense)

        val mealOverExpensesMarker = checkMealOverExpenseMarker(expense)

        printer(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker)
    }

    private fun getExpenseName(expense: Expense): String {
        val expenseName: String = when (expense.type) {
            ExpenseType.DINNER -> "Dinner"
            ExpenseType.BREAKFAST -> "Breakfast"
            ExpenseType.CAR_RENTAL -> "Car Rental"
        }
        return expenseName
    }

    private fun calculateMealExpense(expense: Expense, mealExpenses: Int): Int {
        var mealExpenses1 = mealExpenses
        if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
            mealExpenses1 += expense.amount
        }
        return mealExpenses1
    }

    private fun calculateTotalExpense(total: Int, expense: Expense): Int {
        var total1 = total
        total1 += expense.amount
        return total1
    }

    private fun checkMealOverExpenseMarker(expense: Expense): String {
        return if (expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000) "X" else " "
    }
}
