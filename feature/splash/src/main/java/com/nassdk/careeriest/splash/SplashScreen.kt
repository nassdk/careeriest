package com.nassdk.careeriest.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nassdk.careeriest.common.base.BaseScreen
import com.nassdk.careeriest.ui.kit.ButtonStyle
import com.nassdk.careeriest.ui.kit.STTextButton
import com.nassdk.careeriest.ui.theme.StTheme

internal class SplashScreen : BaseScreen() {

    @Composable
    override fun ScreenContent() {

        val systemUiColor = rememberSystemUiController()

        with(systemUiColor) {
            setNavigationBarColor(color = StTheme.colors.thirdlyBackgroundColor)
            setStatusBarColor(color = StTheme.colors.thirdlyBackgroundColor)
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = StTheme.colors.thirdlyBackgroundColor),
            content = {

                val (image, title, button) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.iv_saly_climb),
                    contentDescription = stringResource(id = R.string.splash_image_content_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(
                            ref = image,
                            constrainBlock = {
                                start.linkTo(anchor = parent.start)
                                top.linkTo(anchor = parent.top)
                                end.linkTo(anchor = parent.end)
                            }
                        )
                )

                Text(
                    text = stringResource(id = R.string.splash_title),
                    style = StTheme.typography.headerMed30,
                    color = StTheme.colors.fifthlyTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxHeight(fraction = 1f)
                        .constrainAs(
                            ref = title,
                            constrainBlock = {
                                start.linkTo(anchor = parent.start)
                                end.linkTo(anchor = parent.end)
                                top.linkTo(anchor = image.bottom)
                            }
                        )
                )

                STTextButton(
                    onClick = {},
                    titleRes = R.string.slpash_start_browsing_button_title,
                    style = ButtonStyle.SECONDARY,
                    modifier = Modifier
                        .padding(bottom = StTheme.dimens.dp24)
                        .height(height = StTheme.dimens.dp52)
                        .constrainAs(
                            ref = button,
                            constrainBlock = {
                                start.linkTo(anchor = parent.start)
                                end.linkTo(anchor = parent.end)
                                bottom.linkTo(anchor = parent.bottom)
                            }
                        ),
                )
            }
        )
    }
}