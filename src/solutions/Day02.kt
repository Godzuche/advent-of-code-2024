package solutions

import println
import readInput
import kotlin.math.absoluteValue

// --- Day 2: Red-Nosed Reports ---

fun main() {
    fun part1(input: List<String>): Long {
        val reports = input.map { it.split(Regex("\\s+")).map { it.toLong() } }
        val safeCount: Long = reports.sumOf { levels: List<Long> ->
            var previousLevelDisparity = 0L
            var safeScore = 0L

            if (levels.size < 2) {
                safeScore = 0L
            } else {
                levels.zipWithNext { a, b ->
                    val safeDecreasing = (a - b) > 0 && previousLevelDisparity >= 0
                    val safeIncreasing = (a - b) < 0 && previousLevelDisparity <= 0
                    val currentLevelDisparity = a - b
                    if ((safeIncreasing || safeDecreasing) && currentLevelDisparity.absoluteValue in 1..3 ){
                        safeScore = 1L
                    } else {
                        return@sumOf 0L
                    }
                    previousLevelDisparity = currentLevelDisparity
                }
            }
            safeScore
        }

        return safeCount
    }

    fun part2(input: List<String>): Long {

        return input.size.toLong()
    }

    val testExampleInput = listOf(
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9",
    )
    val part1TestExample: Pair<List<String>, Long> = testExampleInput to 2
    val part2TestExample: Pair<List<String>, Long> = testExampleInput to 4

    // Test if implementation meets criteria from the example in the description:
    val part1TestInput = part1TestExample.first
    val part1TestResult = part1TestExample.second
    val part1Result = part1(part1TestInput)
    check(part1Result == part1TestResult) {
        "Part 1 test result = $part1Result instead of $part1TestResult Test passed: ${part1Result == part1TestResult}"
    }.also {
        part1(part1TestInput).println {
            "Part 1 test result = $this Test passed: ${this == part1TestResult}"
        }
    }

//    val part2TestInput = part2TestExample.first
//    val part2TestResult = part2TestExample.second
//    val part2Result = part2(part2TestInput)
//    check(part2Result == part2TestResult) {
//        "Part 2 Result = $part2Result instead of $part2TestResult Test passed: ${part2Result == part2TestResult}"
//    }.also {
//        part2(part2TestInput).println {
//            "Part 2 Result = $this Test passed: ${this == part2TestResult}"
//        }
//    }

    // Read the input for day 1.
    val input = readInput(day = 2)

    part1(input).println()
//    part2(input).println()
}
