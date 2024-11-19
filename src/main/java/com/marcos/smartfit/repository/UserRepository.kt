package com.marcos.smartfit.repository

import com.marcos.smartfit.datasource.DataSourceUser
import com.marcos.smartfit.model.User

class UserRepository {
    private val dataSource = DataSourceUser()

    fun salvarUser(u: User){
        dataSource.salvarUser(u);
    }

    fun verificarLogin( cpf: String, pass: String){
        dataSource.loginUser(cpf,pass)
    }
}