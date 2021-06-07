package com.pamella.agenda



data class Agenda(private val name: String, private val phone: String, private var relation: String){
    var contacts: MutableList<Any> = mutableListOf()
    fun addContato() {
        contacts.plusAssign("${name} - ${this.phone} \n ${this.relation}")
    }

    fun showList():MutableList<Any>
    {
        return contacts
    }
}
