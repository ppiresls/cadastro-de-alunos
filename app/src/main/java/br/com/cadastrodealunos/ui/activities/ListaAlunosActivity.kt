package br.com.cadastrodealunos.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.dao.AlunoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaAlunosActivity : AppCompatActivity() {
    private val TITULO_APPBAR = "Lista de Alunos"
    private val alunoDao = AlunoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = TITULO_APPBAR
        setContentView(R.layout.activity_lista_alunos)
        configuraFabNovoAluno()
    }

    private fun configuraFabNovoAluno() {
        val fab: FloatingActionButton = findViewById(R.id.fab_novo_aluno)
        fab.setOnClickListener { view ->
            abreFormularioAluno()
        }
    }

    private fun abreFormularioAluno() {
        startActivity(Intent(this, FormularioAlunoActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        configuraLista()
    }

    private fun configuraLista() {
        val listaAlunos = findViewById<ListView>(R.id.listaAlunos)
        listaAlunos.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                alunoDao.todos())
    }
}