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
        colors = ButtonDefaults.buttonColors(backgroundColor = style.getBackgroundColor()),
        shape = StTheme.shapes.primaryButtonShape,
        modifier = modifier,
        content = {
            Text(
                text = stringResource(id = titleRes).uppercase(),
                style = StTheme.typography.buttonBold15,
                textAlign = TextAlign.Center,
                color = style.getTextColor(),
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
}

@Composable
internal fun ButtonStyle.getBackgroundColor(): Color {
    return if (this == ButtonStyle.PRIMARY) {
        StTheme.colors.primaryButtonColor
    } else {
        StTheme.colors.secondaryButtonColor
    }
}

@Composable
internal fun ButtonStyle.getTextColor(): Color {
    return if (this == ButtonStyle.PRIMARY) {
        StTheme.colors.primaryButtonTextColor
    } else {
        StTheme.colors.secondaryButtonTextColor
    }
}