package day18.generics

class Stack<T>(private val capacity : Int) {

    private var stack : ArrayList<T> = ArrayList<T>(capacity)

    fun push(item : T)
    {
        stack.add(item);
    }

    fun pop() : T{
        return stack.removeFirst();
    }
    fun display(){
        println(stack)
    }
}

fun main() {

    val myStack = Stack<Int>(4);
    myStack.push(10)
    myStack.push(20)
    myStack.push(40)
    myStack.display()


    val myName = Stack<String>(4);
    myName.push("Faraz")
    myName.push("Sameer")
    myName.push("Faisal")
    myName.pop()
    myName.pop()
    myName.display()




}