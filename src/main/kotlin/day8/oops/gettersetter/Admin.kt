package day8.oops.gettersetter


// Requirement is store value in encrypted form and fetch in decrypted form
class Admin {

    var firstName : String = ""
    set(value){
        field = Scrambler.encryptData(value)
    }
    get(){
        return Scrambler.decryptData(field)
    }

    var lastName : String = ""
        set(value){
            field = Scrambler.encryptData(value)
        }
        get(){
            return Scrambler.decryptData(field)
        }


}

object Scrambler{

    // Data of string
    fun encryptData(data : String) : String{
        return reverse(data)
    }

    fun decryptData(data : String) : String{
        return reverse(data);
    }

    private fun reverse(data: String) :String{
        var i = 0
        var j = data.length-1
        var newData = data.toCharArray()
        while(i <= j){
            swap(i,j,newData)
            i++
            j--
        }

        return arrayToString(newData)
    }

    private fun arrayToString(data : CharArray) : String{
        var str : String = ""
        for(i in data)
            str += i
        return str
    }

    private fun swap(i: Int, j: Int, newData: CharArray) {
        var temp = newData[i]
        newData[i] = newData[j]
        newData[j] = temp
    }

}
