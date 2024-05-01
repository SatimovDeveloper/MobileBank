package uz.gita.mobilebank.utils.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.mobilebank.ui.theme.LightGray
import uz.gita.mobilebank.ui.theme.White

@Composable
fun TopAppBarWithNavigation(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            modifier = Modifier.size(40.dp).clip(CircleShape).background(color = LightGray),
            onClick = onClick
        ) {
            Icon(imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "iconBack")

        }

    }

}

@Preview
@Composable
private fun TopAppBarPreview() {
    TopAppBarWithNavigation {

    }
}