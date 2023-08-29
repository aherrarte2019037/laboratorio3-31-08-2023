package com.group5.laboratorio3.ui.pages.holiday_selection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.group5.laboratorio3.model.DesignsEnum
import com.group5.laboratorio3.model.HolidaysEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HolidaySelectionPage(navController: NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var lastname by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf(TextFieldValue("")) }
    var selectedHoliday by remember { mutableStateOf(HolidaysEnum.Christmas) }
    var selectedDesign by remember { mutableStateOf(DesignsEnum.Cartoon) }

    val buttonEnabled =
        name.text.isNotEmpty() && lastname.text.isNotEmpty() && message.text.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(42.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
                textColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {})
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = lastname,
            onValueChange = { lastname = it },
            label = { Text("Lastname") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
                textColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {})
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Congratulations message") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
                textColor = Color.Black,
            ),
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Select holiday",
            fontWeight = FontWeight.SemiBold,
        )
        HolidaysEnum.values().forEach { holiday ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = holiday == selectedHoliday,
                    onClick = { selectedHoliday = holiday }
                )
                Text(holiday.displayableText, Modifier.clickable { selectedHoliday = holiday })
            }
        }

        Spacer(modifier = Modifier.height(18.dp))
        Text(
            "Select design",
            fontWeight = FontWeight.SemiBold,
        )
        DesignsEnum.values().forEach { design ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = design == selectedDesign,
                    onClick = { selectedDesign = design }
                )
                Text(design.displayableText, Modifier.clickable { selectedDesign = design })
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                val holidayParam = selectedHoliday.value
                val designParam = selectedDesign.value
                val nameParam = name.text.trim()
                val lastnameParam = lastname.text.trim()
                val messageParam = message.text.trim()

                navController.navigate("holiday-card/$holidayParam/$designParam/$nameParam/$lastnameParam/$messageParam")
            },
            enabled = buttonEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF279AF1),
            ),
            modifier = Modifier
                .size(width = 280.dp, height = 50.dp)
        ) {
            Text(
                "See Design",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                )
            )
        }
    }
}