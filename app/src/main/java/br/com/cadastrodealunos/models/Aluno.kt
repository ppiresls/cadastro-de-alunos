package br.com.cadastrodealunos.models

import java.io.Serializable

class Aluno(): Serializable {
    private var telefone = ""
    private var email    = ""
    private var nome     = ""
    private var id       = 0

    constructor(nome: String, email: String, telefone: String): this() {
        this.telefone = telefone
        this.email    = email
        this.nome     = nome
    }

    fun getTelefone(): String { return this.telefone }
    fun setTelefone(telefone: String) { this.telefone = telefone }

    fun getEmail(): String { return this.email }
    fun setEmail(email: String) { this.email = email }

    fun getNome(): String { return this.nome }
    fun setNome(nome: String) { this.nome = nome }

    fun setId(id: Int) { this.id = id }
    fun getId(): Int { return this.id }

    fun temIdValido(): Boolean { return this.id > 0 }
    override fun toString(): String { return this.nome }
}
