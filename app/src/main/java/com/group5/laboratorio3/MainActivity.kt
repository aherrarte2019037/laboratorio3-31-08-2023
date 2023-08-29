package com.group5.laboratorio3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.group5.laboratorio3.model.DesignsEnum
import com.group5.laboratorio3.model.HolidaysEnum
import com.group5.laboratorio3.ui.pages.holiday_card.HolidayCardPage
import com.group5.laboratorio3.ui.pages.holiday_selection.HolidaySelectionPage
import com.group5.laboratorio3.ui.pages.home_page.HomePage
import com.group5.laboratorio3.ui.theme.Laboratorio3Theme
import com.group5.laboratorio3.utils.Utils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationContainer()
        }

        Utils.setContext(this)
    }
}

@Preview
@Composable
fun NavigationContainer() {
    val navController = rememberNavController()

    Laboratorio3Theme {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable(route = "home") { HomePage(navController) }
            composable(route = "holiday-selection") { HolidaySelectionPage(navController) }
            composable(route = "holiday-card/{holiday}/{design}/{name}/{lastname}/{message}") { navBackStackEntry ->
                val holidayParam = navBackStackEntry.arguments?.getString("holiday") ?: ""
                val designParam = navBackStackEntry.arguments?.getString("design") ?: ""
                val nameParam = navBackStackEntry.arguments?.getString("name") ?: ""
                val lastnameParam = navBackStackEntry.arguments?.getString("lastname") ?: ""
                val messageParam = navBackStackEntry.arguments?.getString("message") ?: ""

                val holiday = HolidaysEnum.byNameOrNull(holidayParam) ?: HolidaysEnum.Christmas
                val design = DesignsEnum.byNameOrNull(designParam) ?: DesignsEnum.Cartoon

                HolidayCardPage(
                    holiday,
                    design,
                    nameParam,
                    lastnameParam,
                    messageParam,
                )
            }
        }
    }
}