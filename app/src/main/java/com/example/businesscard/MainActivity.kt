package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFc41e3a)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard()
{
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ){
        CardInfo(
            name = "Rendi Wijaya",
            student_id = "(D121211020)",
            title = "Junior Android Developer",
        )
        ContactInfo(
            phone = "+62 853-4203-4482",
            social = "Rendi Wijaya",
            email = "wijayarendi9@gmail.com"
        )
    }
}
@Composable
fun CardInfo(name: String, title: String, student_id: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.logo_resmi_unhas),
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
        )
        Text(
            text = name,
            fontSize = 40.sp,
            color = Color (0xFFFFFFFF)
        )
        Text(
            text = student_id,
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color (0xFFFFFFFF)
        )

        Text(
            text = title,
            color = Color(0xFFFFFFFF)
        )
    }

}

@Composable
fun ContactInfo(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {

        ContactLine(
            iconId = R.drawable.whatsapp,
            message = phone
        )
        ContactLine(
            iconId = R.drawable.linkedin,
            message = social
        )
        ContactLine(
            iconId = R.drawable.email,
            message = email
        )

    }
}

@Composable
fun ContactLine(iconId: Int, message: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val icon = painterResource(id = iconId)
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(start = 100.dp, end = 8.dp)
        )
        Text(
            text = message,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFc41e3a)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}