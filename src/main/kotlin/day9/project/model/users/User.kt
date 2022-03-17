package day9.project.model.users


interface People{}

abstract class User : People {

    private var _username: String = ""
            var username : String
                get() = _username
                set(value){
                    _username = value
                }


    private var _emailId : String = "";
            var emailId : String
                get() = _emailId
                set(value){
                    _emailId = value
                }

    private var _password : String = "";
            var password : String
                get() = _password
                set(value){
                    _password = value
                }

    private var _isAdmin : Boolean = false
            var isAdmin : Boolean
                get() = _isAdmin
                set(value){
                    _isAdmin = value
                }

    private var _isSeller : Boolean = false
            var isSeller : Boolean
                get() = _isSeller
                set(value){
                    _isSeller = value
                }

}
