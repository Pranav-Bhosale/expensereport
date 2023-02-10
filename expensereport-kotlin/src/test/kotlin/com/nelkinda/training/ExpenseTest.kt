package com.nelkinda.training

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@Suppress("DANGEROUS_CHARACTERS")
class ExpenseTest {
    @Test
    fun `should return " " as meal over-expense marker when breakfast amount is within limit`() {
        val expense = Expense(ExpenseType.BREAKFAST, 100)

        val expenseMarker = expense.getIfMealOverExpenseMarker()

        assertEquals(" ", expenseMarker)
    }

    @Test
    fun `should return " " as meal over-expense marker when dinner amount is within limit`() {
        val expense = Expense(ExpenseType.DINNER, 1000)

        val expenseMarker = expense.getIfMealOverExpenseMarker()

        assertEquals(" ", expenseMarker)
    }

    @Test
    fun `should return "X" as meal over-expense marker when dinner amount exceeds`() {
        val expense = Expense(ExpenseType.DINNER, 10000)

        val expenseMarker = expense.getIfMealOverExpenseMarker()

        assertEquals("X", expenseMarker)
    }

    @Test
    fun `should return "X" as meal over-expense marker when breakfast amount exceeds`() {
        val expense = Expense(ExpenseType.BREAKFAST, 1001)

        val expenseMarker = expense.getIfMealOverExpenseMarker()

        assertEquals("X", expenseMarker)
    }

    @Test
    fun `should return "Dinner" as expense name For DINNER expense type`() {
        val expense = Expense(ExpenseType.DINNER, 1001)

        val expenseName = expense.getExpenseName()

        assertEquals("Dinner", expenseName)
    }

    @Test
    fun `should return "Car Rental" as expense name For CAR_RENTAL expense type`() {
        val expense = Expense(ExpenseType.CAR_RENTAL, 1001)

        val expenseName = expense.getExpenseName()

        assertEquals("Car Rental", expenseName)
    }

    @Test
    fun `should return "Breakfast" as expense name For BREAKFAST expense type`() {
        val expense = Expense(ExpenseType.BREAKFAST, 1001)

        val expenseName = expense.getExpenseName()

        assertEquals("Breakfast", expenseName)
    }
}