package com.eviltester.kotlin.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DataClassTest {

    // Data Classes https://kotlinlang.org/docs/data-classes.html

    @Test
    fun `a data class supports decomposing`() {

        // try this with a PersonClass you receive syntax errors
        // can only decompose data classes
        val person = PersonDataClass(name = "my name", age = 23)
        val (name, age) = person

        assertThat(name).isEqualTo(person.name)
        assertThat(age).isEqualTo(person.age)
    }

    @Test
    fun `a data class supports copying`() {

        // immutability is easy with a data class using the copy method
        val person1 = PersonDataClass(name = "my name", age = 23)
        val person2 = person1.copy(age = 43)

        // person 1 is unchanged
        assertThat(person1.name).isEqualTo("my name")
        assertThat(person1.age).isEqualTo(23)

        // person 2 is a new object with some of the values from person1 copied over
        assertThat(person2.name).isEqualTo(person1.name)
        assertThat(person2.age).isNotEqualTo(person1.age)
        assertThat(person2.age).isEqualTo(43)
    }

    @Test
    fun `a data classes can have functions`() {

        val person = PersonDataClassWithAddedFun(name = "my name", age = 23)

        assertThat(person.isOlderThan(21)).isTrue
    }

    @Nested
    inner class EqualityVersusNormalClass {

        @Test
        fun `a data class automatically creates an equals and hashcode based on content`() {

            val person1 = PersonDataClass(name = "my name", age = 23)
            val person2 = PersonDataClass(name = "my name", age = 23)

            // the property values are equal
            assertThat(person1.name).isEqualTo(person2.name)
            assertThat(person1.age).isEqualTo(person2.age)

            // for a data class this means that the objects are equal
            assertThat(person1.equals(person2)).isTrue
            assertThat(person1 == person2).isTrue
            assertThat(person1).isEqualTo(person2)
        }

        @Test
        fun `a normal class uses instance rather than value for equality`() {

            val person1 = PersonClass(name = "my name", age = 23)
            val person2 = PersonClass(name = "my name", age = 23)

            // the property values may be equal
            assertThat(person1.name).isEqualTo(person2.name)
            assertThat(person1.age).isEqualTo(person2.age)

            // so the two objects are not equal
            assertThat(person1.equals(person2)).isFalse
            assertThat(person1 != person2).isTrue()
            assertThat(person1).isNotEqualTo(person2)
        }

        @Test
        fun `data class copy method makes immutability functional style of coding easier`() {

            val person1 = PersonClassImmutability(name = "my name", age = 23)

            // syntax error if try to change the read only properties
//            person1.name="cannot change name"
//            person1.age="cannot change name"

            // create new objects based on old
            val changedName = person1.changeName(newName = "new name")
            assertThat(person1.name).isEqualTo("my name")
            assertThat(changedName.name).isEqualTo("new name")

            // and the age is unchanged
            assertThat(changedName.age).isEqualTo(person1.age)

            val olderPerson = person1.increaseAge(by = 1)
            assertThat(person1.age).isEqualTo(23)
            assertThat(olderPerson.age).isEqualTo(24)

            // and the name is unchanged
            assertThat(olderPerson.name).isEqualTo(person1.name)
        }
    }
}