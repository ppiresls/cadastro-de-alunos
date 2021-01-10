package br.com.cadastrodealunos.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.dao.AlunoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ListaAlunosActivity : AppCompatActivity() {
    private val APPBAR_TITLE = "Lista de Alunos"
    private val alunoDao = AlunoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = APPBAR_TITLE
        setContentView(R.layout.activity_lista_alunos)

        val listaAlunos = findViewById<ListView>(R.id.listaAlunos)
        listaAlunos.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            alunoDao.all())

        val fab: FloatingActionButton = findViewById(R.id.fab_novo_aluno)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Novo Aluno", Snackbar.LENGTH_LONG)
                .show()
        }
    }
}