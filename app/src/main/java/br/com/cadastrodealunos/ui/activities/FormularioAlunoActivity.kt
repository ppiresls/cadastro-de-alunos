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
        val campoTelefone: EditText = findViewById(R.id.activity_formulario_aluno_telefone)
        val campoEmail:    EditText = findViewById(R.id.activity_formulario_aluno_email)
        val campoNome:     EditText = findViewById(R.id.activity_formulario_aluno_nome)

        var aluno = Aluno()
        if (intent.hasExtra("aluno")) {
            aluno = intent.getSerializableExtra("aluno") as Aluno
            setaCamposFormularioParaEdicao(aluno, campoTelefone, campoEmail, campoNome)
        }
        configuraBotaoSalvar(aluno, campoTelefone, campoEmail, campoNome)
    }

    private fun setaCamposFormularioParaEdicao(aluno: Aluno, campoTelefone: EditText, campoEmail: EditText, campoNome: EditText) {
        campoTelefone.setText(aluno.getTelefone())
        campoEmail.setText(aluno.getEmail())
        campoNome.setText(aluno.getNome())
    }

    private fun configuraBotaoSalvar(aluno: Aluno, campoTelefone: EditText, campoEmail: EditText, campoNome: EditText) {
        val botaoSalvar: Button =
                findViewById(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener(View.OnClickListener {
            aluno.setTelefone(campoTelefone.text.toString())
            aluno.setEmail(campoEmail.text.toString())
            aluno.setNome(campoNome.text.toString())
            salvaAlunoEFinalizaActivity(aluno)
        })
    }

    private fun salvaAlunoEFinalizaActivity(aluno: Aluno) {
        alunoDao.salva(aluno)
        finish()
    }
}