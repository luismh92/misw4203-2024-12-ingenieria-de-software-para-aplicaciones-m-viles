package com.example.vinilosmisw4203_2024.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vinilosmisw4203_2024.R

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logovinilos),
            contentDescription = "Logo Vinilos",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = {
                navController.navigate("User")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBDBDBD)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Login as User",
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp),
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate("collectionist")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBDBDBD)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Login as Collectionist",
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp),
                color = Color.Black
            )
        }
    }
}