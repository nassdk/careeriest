package com.nassdk.careeriest.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nassdk.careeriest.common.base.BaseFragment
import com.nassdk.careeriest.ui.theme.StTheme

internal class SplashFragment : BaseFragment() {

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

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = StTheme.colors.secondaryButtonColor),
                    shape = RoundedCornerShape(size = 12.dp),
                    modifier = Modifier
                        .padding(bottom = StTheme.dimens.dp24)
                        .height(height = 52.dp)
                        .constrainAs(
                            ref = button,
                            constrainBlock = {
                                start.linkTo(anchor = parent.start)
                                end.linkTo(anchor = parent.end)
                                bottom.linkTo(anchor = parent.bottom)
                            }
                        ),
                    content = {
                        Text(
                            text = stringResource(id = R.string.slpash_start_browsing_button_title).uppercase(),
                            style = StTheme.typography.buttonBold15,
                            textAlign = TextAlign.Center,
                            color = StTheme.colors.secondaryButtonTextColor,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(horizontal = StTheme.dimens.dp28)
                        )
                    }
                )
            }
        )
    }
}