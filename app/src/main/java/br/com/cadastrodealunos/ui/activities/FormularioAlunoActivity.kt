package br.com.cadastrodealunos.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.dao.AlunoDAO
import br.com.cadastrodealunos.models.Aluno

class FormularioAlunoActivity: AppCompatActivity() {
    private val TITULO_APPBAR = "Novo Aluno"
    private val alunoDao = AlunoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(TITULO_APPBAR)
        setContentView(R.layout.activity_formulario_aluno)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar: Button =
                findViewById(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener(View.OnClickListener {
            val campoTelefone: EditText = findViewById(R.id.activity_formulario_aluno_telefone)
            val campoEmail:    EditText = findViewById(R.id.activity_formulario_aluno_email)
            val campoNome:     EditText = findViewById(R.id.activity_formulario_aluno_nome)

            val aluno = criaAluno(campoTelefone, campoEmail, campoNome)
            salvaAlunoEFinalizaActivity(aluno)
        })
    }

    private fun salvaAlunoEFinalizaActivity(aluno: Aluno) {
        alunoDao.salva(aluno)
        finish()
    }

    private fun criaAluno(campoTelefone: EditText, campoEmail: EditText, campoNome: EditText): Aluno {
        val telefone: String = campoTelefone.text.toString()
        val email:    String = campoEmail.text.toString()
        val nome:     String = campoNome.text.toString()

        return Aluno(nome, email, telefone)
    }
}