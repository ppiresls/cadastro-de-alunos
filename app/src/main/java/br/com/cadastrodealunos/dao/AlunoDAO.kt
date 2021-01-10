package br.com.cadastrodealunos.dao

import br.com.cadastrodealunos.models.Aluno

class AlunoDAO {
    companion object {
        private val alunos = arrayListOf(
                Aluno("Aluno 1", "mail@mail.com", "21 966666666"),
                Aluno("Aluno 2", "mail@mail.com", "21 966666666")
        )
    }

    fun todos(): List<Aluno> {
        return ArrayList(alunos)
    }

    fun salva(aluno: Aluno) {
        alunos.add(aluno)
    }
}