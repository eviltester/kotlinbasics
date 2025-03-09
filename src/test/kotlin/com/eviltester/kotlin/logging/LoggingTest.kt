package com.eviltester.kotlin.logging

import io.github.oshai.kotlinlogging.KotlinLogging.logger
import io.github.oshai.kotlinlogging.withLoggingContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LoggingTest {

    val log = logger{}

    @Test
    fun `not recommended to log using String Param with deprecated Non idiomatic approach`(){
        log.info("Info log as String")
    }

    @Test
    fun `recommended idiomatic Logging uses a lambda`(){
        log.info{ "Info log from lambda"}
    }

    @Test
    fun `logging using lambda with side-effect and the log output is the default return value`(){
        var count = 0

        log.info{
            // not output
            "Info log from lambda $count"

            // side-effect
            count++

            // log output
            "Info log from lambda $count"
        }

        assertThat(count).isEqualTo(1)
    }


    @Test
    fun `use logging context to have multiple logs with same information`(){
        var count = 0

        withLoggingContext(
            mapOf(
                "count" to count.toString()
            )
        ){
            // with more complex logging config the count is also shown in the context of the log
            // useful when working with datadog etc.
            log.info { "Info log from lambda $count" }
            count++
            log.info { "Info log from lambda $count" }
        }

        assertThat(count).isEqualTo(1)
    }

    data class DataThings(val thing1:String = "Data Thing 1", val thing2:String = "Data Thing 2")

    @Test
    fun `can log data class objects directly`(){
        log.info{ "${DataThings()}" }
    }

    class Things(val thing1:String = "Thing 1", val thing2:String = "Thing 2")

    @Test
    fun `can log properties of objects`(){
        val things = Things()
        log.info{ "${things.thing1}, ${things.thing2}" }
    }

}