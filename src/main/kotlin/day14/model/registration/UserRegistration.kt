package day14.model.registration

data class UserRegistration(
        override var contactId: String,
        override var username: String,
        override var contactType: String,
        override var email: String,
        override var password: String
) : User

