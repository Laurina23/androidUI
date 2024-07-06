package com.example.androidui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidui.ui.theme.AndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidUITheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Card(
                        modifier = Modifier.padding(9.dp),
                        elevation = CardDefaults.cardElevation(1.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF4FA))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            val blue = Color(0xFF05658E)
                            Text(text = "Jetpack Compose", fontSize = 30.sp,color= blue)
                            Image(
                                painter = painterResource(id = R.drawable.jetpack_compose_icon_rgb),
                                contentDescription = "Jetpack Compose Logo",
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(bottom = 36.dp)
                            )
                            val green = Color(0xFF0E6740)
                            Text(text = " Login", fontSize = 30.sp, color = green, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
                            Spacer(modifier = Modifier.height(12.dp))
                            var email by remember { mutableStateOf("") }
                            var password by remember { mutableStateOf("") }
                            var passwordVisible by remember { mutableStateOf(false) }
                            OutlinedTextField(
                                value = email,
                                onValueChange = { email = it },
                                label = { Text("Email ID or Mobile Number",fontSize = 14.sp) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password",fontSize = 14.sp) },
                                visualTransformation = if (passwordVisible) VisualTransformation.None
                                else PasswordVisualTransformation(),
                                trailingIcon = {
                                    val image = if (passwordVisible)
                                        painterResource(id = R.drawable.visibility)
                                    else painterResource(id = R.drawable.visibility_off)

                                    IconButton(onClick = { passwordVisible = !passwordVisible },modifier = Modifier.size(24.dp)) {
                                        Icon(painter = image, contentDescription = "Visibility")
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "  Forgot Password?", color = green, textAlign = TextAlign.End, modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ){
                                Button(
                                    onClick = { /* Handle login click */ },
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp)
                                        .height(50.dp)
                                        .width(110.dp)
                                ) {
                                    Text(text = "Login")
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        Text(text = "Don't have an account?", color = Color.Black)
                        Spacer(modifier = Modifier.width(4.dp))
                        val blue = Color(0xFF05658E)
                        Text(text = "Register", color = blue,fontSize = 14.sp)
                    }
                }
            }

        }
    }
}