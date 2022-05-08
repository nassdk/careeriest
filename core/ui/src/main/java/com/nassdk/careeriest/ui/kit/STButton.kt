package com.nassdk.careeriest.ui.kit

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.nassdk.careeriest.ui.theme.StTheme

@Composable
fun STTextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    @StringRes titleRes: Int,
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ButtonStyle.getBackgroundColor(
                type = style
            )
        ),
        shape = StTheme.shapes.primaryButtonShape,
        modifier = modifier,
        content = {
            Text(
                text = stringResource(id = titleRes).uppercase(),
                style = StTheme.typography.buttonBold15,
                textAlign = TextAlign.Center,
                color = ButtonStyle.getTextColor(type = style),
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(horizontal = StTheme.dimens.dp28)
            )
        }
    )
}

enum class ButtonStyle {
    PRIMARY,
    SECONDARY;

    internal companion object {

        @Composable
        fun getBackgroundColor(type: ButtonStyle): Color {
            return if (type == PRIMARY) {
                StTheme.colors.primaryButtonColor
            } else {
                StTheme.colors.secondaryButtonColor
            }
        }

        @Composable
        fun getTextColor(type: ButtonStyle): Color {
            return if (type == PRIMARY) {
                StTheme.colors.primaryButtonTextColor
            } else {
                StTheme.colors.secondaryButtonTextColor
            }
        }
    }
}