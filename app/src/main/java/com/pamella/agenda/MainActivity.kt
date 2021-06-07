package com.pamella.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import android.widget.Toast.LENGTH_LONG


class MainActivity : AppCompatActivity() {

    private lateinit var nameTxt: EditText
    private lateinit var celTxt: EditText
    private lateinit var saveButton: Button
    private lateinit var searchTxt: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var showAllContactsButton: Button
    private lateinit var refTxt: EditText
    private lateinit var emailTxt: EditText
    private lateinit var showContactsTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        bindView()
        showAdd()



        saveButton.setOnClickListener {
            var name = nameTxt?.text.toString()
            var phone = celTxt?.text.toString()

            if(radioButtonSelected?.id == 0 ){
                var ref = refTxt?.text.toString()
                Agenda(name,phone,ref).addContato()
        }
            else{
                var email = emailTxt?.text.toString()
                Agenda(name,phone,email).addContato()
                Agenda.showList()
            }

        }

            searchButton.setOnClickListener {
                var nome = searchTxt?.text.toString()

            }

        showAllContactsButton.setOnClickListener {
                for (i in )

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
        emailTxt = findViewById(R.id.email)
        showContactsTxt = findViewById(R.id.contatostxt)
    }


 private fun showAdd(){
    if(radioButtonSelected?.id == 0 ){
        refTxt.visibility = View.VISIBLE
        emailTxt.visibility = View.GONE
    }
    else {
        refTxt.visibility = View.GONE
        emailTxt.visibility = View.VISIBLE
}
}


      var radioButtonSelected :relation? = null
     fun onRadioButtonClicked(view: View){
        if (view is RadioButton) {

            val checked = view.isChecked

            when (view.id) {
                R.id.buttonPessoal ->
                    if (checked) {
                        radioButtonSelected = relation.PESSOAL
                    }
                R.id.buttonTrabalho -> {
                    if (checked) {
                        radioButtonSelected = relation.TRABALHO
                    }
                }

            }

        }
    }}

