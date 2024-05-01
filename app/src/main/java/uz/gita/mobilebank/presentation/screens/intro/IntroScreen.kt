package uz.gita.mobilebank.presentation.screens.intro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.mobilebank.R
import uz.gita.mobilebank.data.models.IntroUiData
import uz.gita.mobilebank.ui.theme.BackgroundColorWhite
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.TextColorGray
import uz.gita.mobilebank.utils.widgets.ButtonGeneral

class IntroScreen : Screen {
    @Composable
    override fun Content() {

        val dataList = mutableListOf(
            IntroUiData(
                R.drawable.ic_intro_page_one,
                R.string.introPageOneTextTitle,
                R.string.introPageOneText
            ),
            IntroUiData(
                R.drawable.ic_intro_page_two,
                R.string.introPageTwoTextTitle,
                R.string.introPageTwoText
            ),
            IntroUiData(
                R.drawable.ic_intro_page_three,
                R.string.introPageThreeTextTitle,
                R.string.introPageThreeText
            )
        )

        IntroContent(dataList)
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroContent(data:List<IntroUiData>) {
    val pagerState = rememberPagerState(pageCount = {data.size})
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColorWhite)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            contentAlignment = Alignment.Center
        ) {
            PagerContent(
                data = data,
                modifier = Modifier.fillMaxSize(),
                pagerState = pagerState
            )

        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.15f)
                .weight(1f)
        ) {
            ButtonGeneral(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .height(56.dp),
                contentText = "Next"
            ) {

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerContent(data:List<IntroUiData>,modifier: Modifier, pagerState: PagerState) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        HorizontalPager(
            modifier = modifier,
            state = pagerState,
            userScrollEnabled = true
        ) { page ->

           Pages(
               painter = painterResource(id = data[page].imgRes),
               contentDescription = "description$page",
               text1 = stringResource(id = data[page].textTitle),
               text2 = stringResource(id = data[page].text))




//            when (page) {
//                0 -> {
//                    Pages(
//                        painter = painterResource(id = data[page].imgRes),
//                        contentDescription = "pager1",
//                        text1 = stringResource(id = data[page].textTitle),
//                        text2 = stringResource(id = data[page].text)
//                    )
//                }
//
//                1 -> {
//                    Pages(
//                        painter = painterResource(id = R.drawable.ic_intro_page_two),
//                        contentDescription = "pager2",
//                        text1 = stringResource(id = R.string.introPageTwoTextTitle),
//                        text2 = stringResource(id = R.string.introPageTwoText)
//                    )
//                }
//
//                2 -> {
//                    Pages(
//                        painter = painterResource(id = R.drawable.ic_intro_page_three),
//                        contentDescription = "pager3",
//                        text1 = stringResource(id = R.string.introPageThreeTextTitle),
//                        text2 = stringResource(id = R.string.introPageThreeText)
//                    )
//                }
//            }
       }
    }
}

@Composable
private fun Pages(
    painter: Painter,
    contentDescription: String,
    text1: String,
    text2: String,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(horizontal = 24.dp),
            painter = painter,
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(24.dp)
                    .wrapContentHeight()
                    .padding(vertical = 4.dp),
                text = text1,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontWeight = FontWeight(600),
                    color = TextColorBlack,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(24.dp)
                    .wrapContentHeight()
                    .padding(vertical = 4.dp),
                text = text2,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontWeight = FontWeight(400),
                    color = TextColorGray,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewIntro() {
    IntroContent(mutableListOf())
}