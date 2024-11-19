package com.marcos.smartfit.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Login(){


    Column (modifier = Modifier.padding(12.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally)
         {
            Text(
                text = "Smart Fit",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 24.dp))

            var email by remember { mutableStateOf("") }

             OutlinedTextField(
                 value = email,
                 onValueChange ={ email = it},
                 label ={ Text("Email")} ,
                 modifier = Modifier.fillMaxWidth()
             )
             // Espaçamento entre os campos
             Spacer(modifier = Modifier.height(16.dp))

             var pass by remember { mutableStateOf("") }

             OutlinedTextField(
                 value = pass,
                 onValueChange ={ pass = it},
                 label ={ Text("Password")} ,
                 modifier = Modifier.fillMaxWidth()
             )


             Button(
                 onClick = {

                 },
                 modifier = Modifier.fillMaxWidth()
                     .absolutePadding(0.dp,16.dp,0.dp,0.dp)
             ) {
                 Text(text = "Entrar")
             }

             Button(
                 onClick = {

                 },
                 modifier = Modifier.fillMaxWidth()
                     .absolutePadding(0.dp,16.dp,0.dp,0.dp)
             ) {
                 Text(text = "Registrar")
             }


         }



}


@Composable
@Preview
private fun PreviewLogin(){
        Login();
}