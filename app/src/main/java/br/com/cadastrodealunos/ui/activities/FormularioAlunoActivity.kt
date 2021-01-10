package br.com.cadastrodealunos.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.cadastrodealunos.R
import br.com.cadastrodealunos.models.Aluno
import com.google.android.material.snackbar.Snackbar

class FormularioAlunoActivity: AppCompatActivity() {
    private val APPBAR_TITLE = "Novo Aluno"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(APPBAR_TITLE)
        setContentView(R.layout.activity_formulario_aluno)

        val botaoSalvar: Button =
                findViewById(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener(View.OnClickListener {
            val campoTelefone: EditText = findViewById(R.id.activity_formulario_aluno_telefone)
            val campoEmail:    EditText = findViewById(R.id.activity_formulario_aluno_email)
            val campoNome:     EditText  = findViewById(R.id.activity_formulario_aluno_nome)

            val telefone: String = campoTelefone.text.toString()
            val email:    String = campoEmail.text.toString()
            val nome:     String = campoNome.text.toString()

            val aluno = Aluno(nome, email, telefone)
            Snackbar.make(it, "Aluno: ${aluno}", Snackbar.LENGTH_LONG).show()
        })
    }
}