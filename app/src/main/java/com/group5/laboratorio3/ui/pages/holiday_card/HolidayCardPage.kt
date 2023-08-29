package com.group5.laboratorio3.ui.pages.holiday_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.group5.laboratorio3.model.DesignsEnum
import com.group5.laboratorio3.model.HolidaysEnum
import com.group5.laboratorio3.utils.Utils

@Composable
fun HolidayCardPage(
    holiday: HolidaysEnum,
    design: DesignsEnum,
    name: String,
    lastname: String,
    message: String,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        HolidayBackground(holiday = holiday, design = design)
        HolidayMessageInfo(name, lastname, message, holiday, design)
    }
}

@Composable
fun HolidayBackground(holiday: HolidaysEnum, design: DesignsEnum) {
    val holidayValue = holiday.value.lowercase()
    val designValue = design.value.lowercase()
    val source = Utils.getDrawableIdByFileName("${holidayValue}_$designValue")

    Image(
        painter = painterResource(source),
        contentDescription = "Holiday Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HolidayMessageInfo(
    name: String,
    lastname: String,
    message: String,
    holiday: HolidaysEnum,
    design: DesignsEnum
) {
    val aligment = calculateInfoAligment(holiday, design)

    Box(
        contentAlignment = aligment,
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$name $lastname",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = message,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

fun calculateInfoAligment(holiday: HolidaysEnum, design: DesignsEnum): Alignment {
    when (holiday) {
        HolidaysEnum.Christmas -> {
            return when(design) {
                DesignsEnum.Cartoon -> Alignment.BottomCenter
                DesignsEnum.Elegant -> Alignment.Center
                DesignsEnum.Minimalist -> Alignment.BottomCenter
                DesignsEnum.Retro -> Alignment.BottomCenter
            }
        }
        HolidaysEnum.Birthday -> {
            return when(design) {
                DesignsEnum.Cartoon -> Alignment.Center
                DesignsEnum.Elegant -> Alignment.BottomCenter
                DesignsEnum.Minimalist -> Alignment.BottomStart
                DesignsEnum.Retro -> Alignment.BottomStart
            }
        }
        HolidaysEnum.Graduation -> {
            return when(design) {
                DesignsEnum.Cartoon -> Alignment.Center
                DesignsEnum.Elegant -> Alignment.Center
                DesignsEnum.Minimalist -> Alignment.Center
                DesignsEnum.Retro -> Alignment.BottomCenter
            }
        }
        HolidaysEnum.NewYear -> {
            return when(design) {
                DesignsEnum.Cartoon -> Alignment.BottomCenter
                DesignsEnum.Elegant -> Alignment.TopCenter
                DesignsEnum.Minimalist -> Alignment.BottomCenter
                DesignsEnum.Retro -> Alignment.BottomCenter
            }
        }
        HolidaysEnum.Wedding -> {
             return when(design) {
                DesignsEnum.Cartoon -> Alignment.BottomCenter
                DesignsEnum.Elegant -> Alignment.Center
                DesignsEnum.Minimalist -> Alignment.Center
                DesignsEnum.Retro -> Alignment.Center
            }
        }
    }
}