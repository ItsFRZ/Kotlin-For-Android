package day7.thread


class ThreadRunner : Thread(){

    override fun run() {

        synchronized(this){

                    for (i in 1..10) {
                        try{
                            Thread.sleep(200)
                            println(i)
                        }catch (e : Exception){}
                    }
        }

    }

}

fun main() {
//    val trunner = ThreadRunner()
//    Thread(trunner).start()
//    Thread(trunner).start()

    
    
    

}
