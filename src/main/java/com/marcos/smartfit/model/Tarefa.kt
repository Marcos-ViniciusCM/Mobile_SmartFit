package com.marcos.smartfit.model

data class Tarefa(
    val tarefa: String? = null,
    val repeticao: Int? = null,
    val grupoDeExercicio : String? = null,
    val userCpf : Int? = null
){

    fun toMap(): Map<String, Any?> {
        return mapOf(
            "tarefa" to tarefa,
            "repeticao" to repeticao,
            "grupoDeExercicio" to grupoDeExercicio,
            "userCpf"  to userCpf
        )
    }
}
