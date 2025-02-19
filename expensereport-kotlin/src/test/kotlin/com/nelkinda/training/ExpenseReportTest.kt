package com.nelkinda.training

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


class ExpenseReportTest {

    @Test
    fun `should print report`() {
        val output = mutableListOf<String>()

        val dinner = Expense(ExpenseType.DINNER, 500)
        val carRental = Expense(ExpenseType.CAR_RENTAL, 100)
        val breakfast = Expense(ExpenseType.BREAKFAST, 1000000)
        val expectedOutput = listOf(
            "Expenses ${Date()}",
            "Dinner\t500\t ",
            "Car Rental\t100\t ",
            "Breakfast\t1000000\tX",
            "Meal expenses: 1000500",
            "Total expenses: 1000600"
        )
        val expenses = listOf(dinner, carRental, breakfast)

        ExpenseReport().printReport(expenses) { str -> output.add(str) }

        assertEquals(expectedOutput, output)
    }


}

