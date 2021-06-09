package com.pamella.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
import android.view.View
import android.view.WindowManager
import android.widget.*
import android.widget.Toast.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var nameTxt: EditText
    private lateinit var celTxt: EditText
    private lateinit var saveButton: Button
    private lateinit var searchTxt: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var showAllContactsButton: Button
    private lateinit var refTxt: EditText
    private lateinit var showContactsTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        bindView()
        val contacts = Agenda()

        saveButton.setOnClickListener {
            val name = nameTxt.text.toString()
            val phone = celTxt.text.toString()
            val ref = refTxt.text.toString()
            if (name.isEmpty())  nameTxt.error="Insira o nome!"
            if (phone.isEmpty())  celTxt.error="Insira o telefone!"

            showContactsTxt.text = contacts.addContact(name, phone, ref)
            nameTxt.text.clear()
            celTxt.text.clear()
            refTxt.text.clear()
            makeText(this, "Contato cadastrado!", LENGTH_SHORT).show()
        }



            searchButton.setOnClickListener {
                val search = searchTxt.text.toString()
                if(search.isNotEmpty()){
                    showContactsTxt.text = contacts.consultList(search)
                    searchTxt.text.clear()
                }
                if(search.isEmpty()) searchTxt.error = "Informe um nome para consultar."
                else {
                    makeText(this, "Contato não cadastrado!", LENGTH_SHORT).show()
                }

            }


            showAllContactsButton.setOnClickListener()
            {
                showContactsTxt.text = contacts.listFinal()
            }
        }

     private fun bindView() {
        nameTxt = findViewById(R.id.nome)
        celTxt = findViewById(R.id.telefone)
        saveButton = findViewById(R.id.saveB)
        searchTxt = findViewById(R.id.pesquisar)
        searchButton = findViewById(R.id.imageButton)
        showAllContactsButton = findViewById(R.id.mostrarcontatosB)
        refTxt = findViewById(R.id.referencia)
        showContactsTxt = findViewById(R.id.contatostxt)
    }

     fun onRadioButtonClicked(view: View){
        if (view is RadioButton) {

            val checked = view.isChecked

            when (view.id) {
                R.id.buttonPessoal ->
                    if (checked) {
                        refTxt.inputType = TYPE_CLASS_TEXT
                        refTxt.hint = "Referência"
                    }
                R.id.buttonTrabalho -> {
                    if (checked) {
                        refTxt.inputType = TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
                        refTxt.hint = "E-mail"
                    }
                }

            }

        }
    }}

