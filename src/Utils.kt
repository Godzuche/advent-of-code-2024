import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/resources/$name.txt").readText().trim().lines()

/**
 * Reads lines from the input txt file for the given day.
 */
fun readInput(day: Int): List<String> = Path(getResourcePath(fileName = getFileName(day)))
    .readText()
    .trim()
    .lines()

fun getFileName(day: Int) = "Day${day.toString().padStart(2, '0')}"
fun getResourcePath(fileName: String = "") = "src/resources/$fileName.txt"

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println(
    transform: Any?.() -> String = { this.toString() }
) = println(transform())
