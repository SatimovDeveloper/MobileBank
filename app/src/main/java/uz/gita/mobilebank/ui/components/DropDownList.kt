package uz.gita.mobilebank.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.mobilebank.utils.myLog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownList(
    modifier: Modifier = Modifier,
    itemList:List<String>,
    getValue:(String)->Unit

) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember{ mutableStateOf(itemList[0]) }
    Column (modifier = modifier){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange ={isExpanded = !isExpanded}
        ) {
            OutlinedTextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                shape = RoundedCornerShape(12.dp),
                readOnly = true,
                onValueChange = {
                    it.myLog()
                                },
                trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {isExpanded = false }
            ) {
                itemList.forEachIndexed { index, itemText ->
                    DropdownMenuItem(
                        text = { Text(text = itemText) },
                        onClick = {
                            selectedText = itemList[index]
                            getValue.invoke(selectedText)
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }

            }
        }
    }


    
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    DropdownList(
        modifier = Modifier.fillMaxWidth(),
        itemList = listOf("Erkak", "Ayol"),
        getValue = {}
    )

}