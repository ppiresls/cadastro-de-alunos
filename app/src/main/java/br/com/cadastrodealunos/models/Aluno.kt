package br.com.cadastrodealunos.models

class Aluno(val nome: String, val email: String, val telefone: String) {
    override fun toString(): String { return this.nome }
}
