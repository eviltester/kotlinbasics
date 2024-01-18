import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinExampleTest {

    // methods are functions in Kotlin
    @Test
    fun `Kotlin test names can use string literals with spaces`(){

        // Kotlin does not need semi-colons at the end of lines
        assertThat(true).isTrue()
    }
}