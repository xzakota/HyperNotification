package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.TextField

@Composable
fun SectionTextAndColorInfo(
    title: String,
    onTitleChange: (String) -> Unit,
    colorTitle: String,
    onColorTitleChange: (String) -> Unit,
    colorTitleDark: String,
    onColorTitleDarkChange: (String) -> Unit,
    subTitle: String,
    onSubTitleChange: (String) -> Unit,
    colorSubTitle: String,
    onColorSubTitleChange: (String) -> Unit,
    colorSubTitleDark: String,
    onColorSubTitleDarkChange: (String) -> Unit,
    content: String,
    onContentChange: (String) -> Unit,
    colorContent: String,
    onColorContentChange: (String) -> Unit,
    colorContentDark: String,
    onColorContentDarkChange: (String) -> Unit,
    subContent: String,
    onSubContentChange: (String) -> Unit,
    colorSubContent: String,
    onColorSubContentChange: (String) -> Unit,
    colorSubContentDark: String,
    onColorSubContentDarkChange: (String) -> Unit,
    extraTitle: String,
    onExtraTitleChange: (String) -> Unit,
    colorExtraTitle: String,
    onColorExtraTitleChange: (String) -> Unit,
    colorExtraTitleDark: String,
    onColorExtraTitleDarkChange: (String) -> Unit,
    specialTitle: String,
    onSpecialTitleChange: (String) -> Unit,
    colorSpecialTitle: String,
    onColorSpecialTitleChange: (String) -> Unit,
    colorSpecialTitleDark: String,
    onColorSpecialTitleDarkChange: (String) -> Unit,
    colorSpecialBg: String,
    onColorSpecialBgChange: (String) -> Unit
) {
    TextField(
        value = title,
        onValueChange = onTitleChange,
        label = "title",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorTitle,
        onValueChange = onColorTitleChange,
        label = "colorTitle (Hex, e.g. #FF0000)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorTitleDark,
        onValueChange = onColorTitleDarkChange,
        label = "colorTitleDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = subTitle,
        onValueChange = onSubTitleChange,
        label = "subTitle",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSubTitle,
        onValueChange = onColorSubTitleChange,
        label = "colorSubTitle (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSubTitleDark,
        onValueChange = onColorSubTitleDarkChange,
        label = "colorSubTitleDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = content,
        onValueChange = onContentChange,
        label = "content",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorContent,
        onValueChange = onColorContentChange,
        label = "colorContent (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorContentDark,
        onValueChange = onColorContentDarkChange,
        label = "colorContentDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = subContent,
        onValueChange = onSubContentChange,
        label = "subContent",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSubContent,
        onValueChange = onColorSubContentChange,
        label = "colorSubContent (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSubContentDark,
        onValueChange = onColorSubContentDarkChange,
        label = "colorSubContentDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = extraTitle,
        onValueChange = onExtraTitleChange,
        label = "extraTitle",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorExtraTitle,
        onValueChange = onColorExtraTitleChange,
        label = "colorExtraTitle (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorExtraTitleDark,
        onValueChange = onColorExtraTitleDarkChange,
        label = "colorExtraTitleDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = specialTitle,
        onValueChange = onSpecialTitleChange,
        label = "specialTitle",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSpecialTitle,
        onValueChange = onColorSpecialTitleChange,
        label = "colorSpecialTitle (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSpecialTitleDark,
        onValueChange = onColorSpecialTitleDarkChange,
        label = "colorSpecialTitleDark (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
    TextField(
        value = colorSpecialBg,
        onValueChange = onColorSpecialBgChange,
        label = "colorSpecialBg (Hex)",
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
    )
}
