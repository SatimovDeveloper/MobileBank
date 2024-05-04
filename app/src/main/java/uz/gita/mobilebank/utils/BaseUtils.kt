package uz.gita.mobilebank.utils

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import timber.log.Timber
import uz.gita.mobilebank.ui.theme.DarkGray
import uz.gita.mobilebank.ui.theme.TextColorBlue

fun String.myLog(tag:String = "Tag") = Timber.tag(tag).d(this)

@Composable
fun RowScope.TabNavigatorItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = {
            Text(
                text = tab.options.title,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 12.sp
            )
        },
        icon = { Icon(
            modifier = Modifier.padding(top =16.dp),
            painter = tab.options.icon!!, contentDescription = tab.options.title) },
        selectedContentColor = TextColorBlue,
        unselectedContentColor = DarkGray
    )
}

fun String.getCardNumberForUi():String{
    val sb = StringBuilder()
    for (i in indices){
        if (i%4 == 0 && i !=0) sb.append("   ").append(this[i])
        else sb.append(this[i])
    }
    return sb.toString()
}
