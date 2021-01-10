package br.com.cadastrodealunos.dao

import br.com.cadastrodealunos.models.Aluno

class AlunoDAO {
    private val alunos: List<Aluno> = listOf(
            Aluno("Aluno 1", "mail@mail.com", "21 966666666"),
            Aluno("Aluno 2", "mail@mail.com", "21 966666666")
    )

    fun all(): List<Aluno> {
        return ArrayList(this.alunos)
    }
}