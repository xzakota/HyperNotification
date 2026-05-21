package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField

import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor

@Composable
fun SectionShareData(
    shareTitle: String,
    onShareTitleChange: (String) -> Unit,
    shareContent: String,
    onShareContentChange: (String) -> Unit,
    sharePic: String,
    onSharePicChange: (String) -> Unit,
    shareContentText: String,
    onShareContentTextChange: (String) -> Unit,
    sharePicUrl: String,
    onSharePicUrlChange: (String) -> Unit
) {
    Column {
        SmallTitle(text = "拖拽分享参数 (shareData)")
        Card(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = shareTitle,
                onValueChange = onShareTitleChange,
                label = "title (拖拽卡片标题)",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = shareContent,
                onValueChange = onShareContentChange,
                label = "content (拖拽卡文案描述)",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            ImagePickerPreference(
                title = "pic",
                summary = "拖拽时卡片上的展示图片 (建议 224*224px)",
                imageSpec = ImagePickerAndProcessor.ImageSpec.SHARE_PIC,
                currentPath = sharePic,
                onPathChange = onSharePicChange
            )
            TextField(
                value = shareContentText,
                onValueChange = onShareContentTextChange,
                label = "shareContent (要分享的正文内容)",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
            TextField(
                value = sharePicUrl,
                onValueChange = onSharePicUrlChange,
                label = "sharePic (要分享的图片网络链接)",
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
        }
    }
}
