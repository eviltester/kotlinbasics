package com.eviltester.kotlin.classes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ClassConstructorTest {

    @Test
    fun `constructor params can automatically be used as properties`() {

        val anObject = ClassWithProperties("getterSetter", "readOnly", "private")

        assertThat(anObject.getterSetter).isEqualTo("getterSetter")
        assertThat(anObject.readOnly).isEqualTo("readOnly")

        // cannot access private directly - this would give a syntax error
        // assertThat(anObject.private).isEqualTo("private")
        assertThat(anObject.getPrivate()).isEqualTo("private")

        anObject.getterSetter = "set"
        assertThat(anObject.getterSetter).isEqualTo("set")

        // anObject.readOnly = "cannot set, syntax error"
    }

    @Test
    fun `method and constructor params can named`() {

        // recommend calling methods with named syntax for params
        val anObject = ClassWithProperties(
            getterSetter = "getty",
            readOnly = "ready",
            privateString = "private"
        )

        assertThat(anObject.getterSetter).isEqualTo("getty")
        assertThat(anObject.readOnly).isEqualTo("ready")

    }

    @Test
    fun `a class constructor can have default values`() {

        val anObject = ClassWithDefaultProperties()

        assertThat(anObject.name).isEqualTo("my name")
    }

    @Test
    fun `init blocks are executed during initialization`() {

        val anObject = ClassWithInitBlocks(firstname = "J.R.", middleName = "Bob", surname = "Dobbs")

        assertThat(anObject.getPraised()).isTrue
        assertThat(anObject.getFullName()).isEqualTo("J.R. \"Bob\" Dobbs")
    }


    @Test
    fun `val and var properties auto create getters and setters`() {

        val anObject = ClassWithAccessibleProperties(firstname = "Bob", surname = "Dobbs")

        assertThat(anObject.fullName).isEqualTo("Bob Dobbs")
        assertThat(anObject.amendName).isEqualTo("Bob Dobbs")

        // need to create access methods for private properties
        assertThat(anObject.getPrivateName()).isEqualTo("Bob Dobbs")

        anObject.amendName = "J.R. 'Bob' Dobbs"
        assertThat(anObject.amendName).isEqualTo("J.R. 'Bob' Dobbs")
    }

    @Test
    fun `properties are not nullable by default`() {

        // nullableMiddleName is declared as nullable with ? and provided a default value
        val anObject = ClassWithNullableProperties(firstname = "Bob", surname = "Dobbs")
        assertThat(anObject.nullableMiddleName).isNull()
    }

}


