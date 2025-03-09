package com.eviltester.kotlin.classes

class ClassWithProperties(var getterSetter: String, val readOnly: String, private val privateString: String) {
    fun getPrivate(): String {
        return privateString
    }

    // 'getters' and 'setters' created automatically based on the
    // var, val and scoping (private) in the class declaration


}

// no need for the body { ... } when there are no methods
class ClassWithDefaultProperties(var name: String = "my name")

class ClassWithAccessibleProperties(val firstname: String, val surname: String) {

    val fullName = "$firstname $surname"
    var amendName = "$firstname $surname"
    private val privateName = "$firstname $surname"

    // cannot create these methods because there are auto created by Kotlin to the JVM as `.propertyName` access
    // i.e. `.fullName`
    // fun getFullName() = fullName

    // i.e. `.amendName`
    //fun getAmendName() = amendName

    // no default methods are created for private properties
    fun getPrivateName() = privateName
}

class ClassWithNullableProperties(val firstname: String, val nullableMiddleName: String? = null, val surname: String)