package br.com.cadastrodealunos.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.models.Aluno

class ListaAlunosActivity : AppCompatActivity() {
    private val APPBAR_TITLE = "Lista de Alunos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = APPBAR_TITLE
        setContentView(R.layout.activity_lista_alunos)

        val alunos =
            listOf(
                Aluno("Aluno 1"),
                Aluno("Aluno 2"),
                Aluno("Aluno 3"),
                Aluno("Aluno 4"),
                Aluno("Aluno 5"),
                Aluno("Aluno 6"),
                Aluno("Aluno 7"))

        val listaAlunos = findViewById<ListView>(R.id.listaAlunos)
        listaAlunos.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            alunos)
    }
}