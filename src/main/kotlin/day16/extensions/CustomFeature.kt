package day16.extensions




fun Int.nextPrime() : Int{

    val myNumber : Int = this
    var nextPrime : Int = -1;

    if(myNumber <= 2){
        nextPrime = 2;
    }else{

        for (no in myNumber..100000){
            if(isPrime(no))
            {
                nextPrime = no;
                break;
            }
        }

    }

    return nextPrime;
}

fun isPrime(no: Int): Boolean {
     for(i in no-1 downTo 2){
        if(no%i == 0)
        {
            return false;
        }
    }
    return true;
}

fun Int.nextEven() : Int{
    if(this%2==0)
        return this;
    return this+1;
}

fun main() {

    val myPrime : Int = (4).nextPrime();
    println(myPrime)
    println(myPrime.nextEven())

}
