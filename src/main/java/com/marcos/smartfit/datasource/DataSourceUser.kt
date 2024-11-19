package com.marcos.smartfit.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.marcos.smartfit.hash.hashPasswordSHA256
import com.marcos.smartfit.model.User


class DataSourceUser {

    private val db = FirebaseFirestore.getInstance()


    fun salvarUser(u: User) {

        val newPass = hashPasswordSHA256(u.pass.toString())

        val UserMap = hashMapOf(
            "nome" to u.nome,
            "cpf" to u.cpf,
            "pass" to newPass
        )


        db.collection("Users")
            .add(UserMap)
            .addOnCompleteListener { }
            .addOnFailureListener { }
    }

    fun loginUser(
        cpf: String,
        pass: String,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val db = FirebaseFirestore.getInstance()

        // Criando uma instância do User para armazenar os dados
        val u = User()

        // Acessando o documento do Firestore
        db.collection("Users").document(cpf)
            .addSnapshotListener { document, error ->
                if (error != null) {
                    // Caso haja um erro
                    return@addSnapshotListener
                }

                if (document != null && document.exists()) {
                    // Preenchendo os campos do objeto User
                    val storedNome = document.getString("nome") ?: "Nome não encontrado"
                    val storedPass = document.getString("pass") ?: "Senha não encontrada"

                    val newPass = hashPasswordSHA256(pass)
                    if (storedPass == newPass) {
                        onSuccess("Login bem-sucedido. Bem-vindo, $storedNome!")

                    } else {
                        // Senha incorreta
                        onFailure("Senha incorreta.")
                    }
                } else {
                    onFailure("Usuário não encontrado.")
                }
            }
    }

    fun loginUser(cpf: String, pass: String) {

    }
}