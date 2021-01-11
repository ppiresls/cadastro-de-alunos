package br.com.cadastrodealunos.dao

import android.util.Log
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

    private fun edita(aluno: Aluno) {
        val id = aluno.getId()
        val position = buscaPosicaoAluno(id)
        alunos.set(position, aluno)
    }

    private fun buscaPosicaoAluno(id: Int): Int {
        var position = 0
        var aluno = alunos.get(position)
        var alunoNaoEncontrado = aluno.getId() != id

        while (alunoNaoEncontrado) {
            position++
            aluno = alunos.get(position)
            alunoNaoEncontrado = aluno.getId() != id
        }

        return position
    }

    private fun insere(aluno: Aluno) {
        contadorDeId++
        aluno.setId(contadorDeId)
        alunos.add(aluno)
    }
}