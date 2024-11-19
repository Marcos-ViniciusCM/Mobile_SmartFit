package com.marcos.smartfit.datasource

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.marcos.smartfit.hash.hashPasswordSHA256
import com.marcos.smartfit.model.Tarefa
import com.marcos.smartfit.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSourceTarefa {

    private val db = FirebaseFirestore.getInstance()
    val database = FirebaseDatabase.getInstance().reference

    private val _todasTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todasTarefas: StateFlow<MutableList<Tarefa>> = _todasTarefas

    fun salvarTarefa(t : Tarefa, cpf: String) {


        val tarefaMap= hashMapOf(
            "tarefa" to t.tarefa,
            "repeticao" to t.repeticao,
            "grupoDeExercicio" to t.grupoDeExercicio,
            "userCpf"  to t.userCpf
        )


        db.collection("Tarefas")
            .add(tarefaMap)
            .addOnCompleteListener { }
            .addOnFailureListener { }
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {

        val listaTarefas: MutableList<Tarefa> = mutableListOf()

        db.collection("Tarefas").get().addOnCompleteListener { querySnapshot ->
            for (documento in querySnapshot.result) {
                val tarefa =  documento.toObject(Tarefa::class.java)
                listaTarefas.add(tarefa)
                _todasTarefas.value = listaTarefas
            }
        }

        return todasTarefas
    }

    fun deletarTarefa(titulo: String) {

        db.collection("tarefas")
            .document(titulo)
            .delete()
            .addOnCompleteListener {  }
            .addOnFailureListener {  }
    }

    fun atualizarTarefa(tarefa:String , repeticao : Int , grupoDeExercicio : String ) {

        val key = database.child("tarefas").push().key
        if (key == null) {
            Log.w(TAG, "Couldn't get push key for posts")
            return
        }

        val tarefa = Tarefa(tarefa, repeticao, grupoDeExercicio)
        val tarefaValue = tarefa.toMap()

        val childUpdates = hashMapOf<String, Any>(
            "/tarefas/$key" to tarefaValue, // Caminho para armazenar a tarefa
            "/user-tarefas/$tarefa/$key" to tarefaValue // Caminho para armazenar a tarefa associada ao usuário
        )

        database.updateChildren(childUpdates)
            .addOnSuccessListener {
                // Sucesso na atualização dos dados
                Log.d(TAG, "Tarefa atualizada com sucesso!")
            }
            .addOnFailureListener {
                // Falha na atualização dos dados
                Log.w(TAG, "Falha ao atualizar a tarefa.")
            }


    }
}