package uz.gita.mobilebank.presentation.screens.intro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.mobilebank.R
import uz.gita.mobilebank.data.models.IntroUiData
import uz.gita.mobilebank.ui.components.ButtonGeneral
import uz.gita.mobilebank.ui.theme.BackgroundColorWhite
import uz.gita.mobilebank.ui.theme.ButtonColor
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.TextColorGray
import uz.gita.mobilebank.ui.theme.UnselectedDotsColor
import uz.gita.mobilebank.utils.myLog

class IntroScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel: IntroContract.IntroViewModel = getViewModel<IntroViewModelImp>()

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
        IntroContent(
            dataList,
            uiState = viewModel.collectAsState().value,
            onEventDispatcher = viewModel::onEventDispatcher
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroContent(
    data: List<IntroUiData>,
    uiState: IntroContract.UiState,
    onEventDispatcher: (IntroContract.Intent) -> Unit

) {
    val pagerState = rememberPagerState(pageCount = { data.size })
    var currentPage by remember { mutableStateOf(0) }

    "Intro Screen $currentPage ".myLog()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColorWhite)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
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
                .fillMaxHeight(0.2f)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ButtonGeneral(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .height(56.dp),
                contentText = "Next",
                onClicked = {
                    if (currentPage == data.size - 1) {
                        "Sign In Screenga o'tdi".myLog()
                        onEventDispatcher(IntroContract.Intent.ClickNext)
                    } else currentPage += 1

                }
            )
        }

    }

    LaunchedEffect(currentPage) {
        pagerState.animateScrollToPage(currentPage)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerContent(data: List<IntroUiData>, modifier: Modifier, pagerState: PagerState) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        HorizontalPager(
            modifier = modifier,
            state = pagerState,
            userScrollEnabled = false
        ) { page ->

            Pages(
                painter = painterResource(id = data[page].imgRes),
                contentDescription = "description$page",
                text1 = stringResource(id = data[page].textTitle),
                text2 = stringResource(id = data[page].text),
                pager = pagerState,
                totalDots = data.size
            )


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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Pages(
    painter: Painter,
    contentDescription: String,
    text1: String,
    text2: String,
    pager: PagerState,
    totalDots: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )

            DotsIndicator(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter),
                totalDots = totalDots,
                selectedIndex = pager.currentPage,
                selectedColor = ButtonColor,
                unSelectedColor = UnselectedDotsColor
            )


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
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
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
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
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color
) {
    LazyRow(modifier = modifier) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }


        }

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun PreviewIntro() {
//    IntroContent(mutableListOf())
//}