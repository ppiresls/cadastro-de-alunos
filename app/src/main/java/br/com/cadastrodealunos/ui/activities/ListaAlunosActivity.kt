package br.com.cadastrodealunos.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.dao.AlunoDAO
import br.com.cadastrodealunos.models.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaAlunosActivity : AppCompatActivity() {
    private val TITULO_APPBAR = "Lista de Alunos"
    private val alunoDao = AlunoDAO()
    private lateinit var adapter: ArrayAdapter<Aluno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = TITULO_APPBAR
        setContentView(R.layout.activity_lista_alunos)
        configuraFabNovoAluno()
    }

    override fun onResume() {
        super.onResume()
        configuraLista()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.activity_lista_alunos_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId

        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            val menuInfo = item.menuInfo as AdapterContextMenuInfo
            val aluno = adapter.getItem(menuInfo.position) as Aluno
            alunoDao.deleta(aluno)
            atualizaListView(adapter)
        }

        return super.onContextItemSelected(item)
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

    private fun configuraLista() {
        val listaAlunos = findViewById<ListView>(R.id.listaAlunos)
        configuraAdapter(listaAlunos)
        configuraOnItemClick(listaAlunos)
        registerForContextMenu(listaAlunos)
    }

    private fun configuraAdapter(listaAlunos: ListView) {
        adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                alunoDao.todos())
        listaAlunos.adapter = adapter
    }

    private fun configuraOnItemClick(listaAlunos: ListView) {
        listaAlunos.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            val aluno = parent.getItemAtPosition(position) as Aluno
            val intent = Intent(this, FormularioAlunoActivity::class.java)
            intent.putExtra("aluno", aluno)
            startActivity(intent)
        }
    }

    private fun atualizaListView(adapter: ArrayAdapter<Aluno>) {
        adapter.clear()
        adapter.addAll(alunoDao.todos())
    }
}