package com.nelkinda.training

import java.util.*

enum class ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}


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
        val expenseName: String = expense.getExpenseName()
        val mealOverExpensesMarker = expense.getIfMealOverExpenseMarker()

        printer(expenseName + "\t" + expense.getExpenseAmount() + "\t" + mealOverExpensesMarker)
    }


    private fun calculateMealExpense(expense: Expense, mealExpenses: Int): Int {
        var newMealExpense = mealExpenses
        val expenseType = expense.getExpenseType()
        val expenseAmount = expense.getExpenseAmount()

        if (expenseType == ExpenseType.DINNER || expenseType == ExpenseType.BREAKFAST) {
            newMealExpense += expenseAmount
        }

        return newMealExpense
    }

    private fun calculateTotalExpense(total: Int, expense: Expense): Int {
        var newTotal = total
        val expenseAmount = expense.getExpenseAmount()

        newTotal += expenseAmount

        return newTotal
    }

}
