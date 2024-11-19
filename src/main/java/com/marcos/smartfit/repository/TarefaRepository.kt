package com.marcos.smartfit.repository

import com.marcos.smartfit.datasource.DataSourceTarefa
import com.marcos.smartfit.datasource.DataSourceUser
import com.marcos.smartfit.model.Tarefa

class TarefaRepository {
    private val dataSource = DataSourceTarefa()


    fun salvarTarefa(t: Tarefa , cpf : String){
        dataSource.salvarTarefa(t,cpf)
    }

    fun DeletarTarefa(t: String){
        dataSource.deletarTarefa(t)
    }

    fun AtualizarTarefa(tarefa:String , repeticao : Int , grupoDeExercicio : String){
        dataSource.atualizarTarefa(tarefa , repeticao  , grupoDeExercicio )
    }
}