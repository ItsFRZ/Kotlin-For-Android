package day14.model.registration

data class UserRegistration(
        override var uid: String,
        override var username: String,
        override var usermode: String,
        override var password: String,
        override var email: String
) : User