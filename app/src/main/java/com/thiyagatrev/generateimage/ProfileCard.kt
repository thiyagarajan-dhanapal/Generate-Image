package com.thiyagatrev.generateimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiyagatrev.generateimage.ui.theme.Typography

@Composable
fun ProfileCard( name:String="",designation:String="") {
    Card(modifier= Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(40.dp),
            shape = RoundedCornerShape(22.dp)
        ) {
            Column(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .shadow(
                            elevation = 20.dp,
                            shape = CircleShape,
                            clip = true
                        )
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = name, style = Typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = designation, style = Typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Works in",style = Typography.bodyLarge
                )


                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Techie | Fitness freak | UI/UX lover | Blogger", style = Typography.bodyLarge
                )
            }
        }
    }

@Preview
@Composable
fun preview(){

    ProfileCard(name = "thiyaga",designation="dev")

}
