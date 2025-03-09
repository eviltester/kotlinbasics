import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class KotlinNestedExampleTest {

    @Nested
    @DisplayName("Should show the tests in a hierarchy")
    inner class NestedTest {
        val nestedValue = "Bob"

        @Test
        @DisplayName("to help organise tests")
        fun InnerTestOrganise() {
            assertThat(true).isTrue()
        }

        @Test
        @DisplayName("to help make the output readable")
        fun InnerTestOutput() {
            assertThat(true).isTrue()
        }

        @Test
        @DisplayName("to have some data context unique to nested test")
        fun InnerTestData() {
            assertThat(true).isTrue()
            assertThat(nestedValue).isEqualTo("Bob")
        }
    }

    @Test
    fun `Kotlin test names can be at a top level`() {

        assertThat(true).isTrue()
    }
}