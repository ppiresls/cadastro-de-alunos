package br.com.cadastrodealunos.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.models.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ListaAlunosActivity : AppCompatActivity() {
    private val APPBAR_TITLE = "Lista de Alunos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = APPBAR_TITLE
        setContentView(R.layout.activity_lista_alunos)

        val alunos =
            listOf(
                Aluno("Aluno 1", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 2", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 3", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 4", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 5", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 6", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 7", "mail@mail.com", "21 966666666"))

        val listaAlunos = findViewById<ListView>(R.id.listaAlunos)
        listaAlunos.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            alunos)

        val fab: FloatingActionButton = findViewById(R.id.fab_novo_aluno)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Novo Aluno", Snackbar.LENGTH_LONG)
                .show()
        }
    }
}