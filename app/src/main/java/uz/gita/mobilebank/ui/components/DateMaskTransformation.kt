package uz.gita.mobilebank.ui.components

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

object DateMaskTransformation:VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return maskFilter(text)
    }
    private fun maskFilter(text: AnnotatedString):TransformedText{

        val trimmed = if(text.text.length>=8) text.text.substring(0..7) else text.text
        var out = ""

        for (i in trimmed.indices){
            out +=trimmed[i]
            if (listOf(1,3).contains(i)) out +="."
        }
        val numberOffsetTranslator = object :OffsetMapping{
            override fun originalToTransformed(offset: Int): Int {
                if (offset<=1) return offset
                if (offset<=4) return offset+1
                if (offset<=8) return offset+2
                return 10
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset<=2) return offset
                if (offset<=6) return offset-1
                if (offset<=10) return offset-2
                return 8
            }
        }
        return TransformedText(AnnotatedString(out),numberOffsetTranslator)
    }
}