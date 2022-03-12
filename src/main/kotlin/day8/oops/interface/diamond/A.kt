package day8.oops.`interface`.diamond

interface A {

    fun foo();
}


interface B : A {
    override fun foo() {
        println("B called")
    }
}

interface C : A{
    override fun foo() {
        println("C called")
    }
}


class D() : B,C{
    override fun foo() {
        super<B>.foo()
        super<C>.foo()
    }
}


