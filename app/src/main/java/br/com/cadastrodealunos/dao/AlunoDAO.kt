package br.com.cadastrodealunos.dao

import br.com.cadastrodealunos.models.Aluno

class AlunoDAO {
    companion object {
        private var contadorDeId = 0
        private val alunos = ArrayList<Aluno>()
    }

    fun todos(): List<Aluno> {
        return ArrayList(alunos)
    }

    fun salva(aluno: Aluno) {
        if (aluno.temIdValido()) edita(aluno) else insere(aluno)
    }

    private fun insere(aluno: Aluno) {
        contadorDeId++
        aluno.setId(contadorDeId)
        alunos.add(aluno)
    }

    private fun edita(aluno: Aluno) {
        val id = aluno.getId()
        val position = buscaPosicaoAluno(id)
        alunos.set(position, aluno)
    }

    fun deleta(aluno: Aluno) {
        val id = aluno.getId()
        val posicao = buscaPosicaoAluno(id)
        alunos.removeAt(posicao)
    }

    private fun buscaPosicaoAluno(id: Int): Int {
        var posicao = 0
        var aluno = alunos.get(posicao)
        var alunoNaoEncontrado = aluno.getId() != id

        while (alunoNaoEncontrado) {
            posicao++
            aluno = alunos.get(posicao)
            alunoNaoEncontrado = aluno.getId() != id
        }

        return posicao
    }
}