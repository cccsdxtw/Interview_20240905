//飛行-顯示(一張)

package com.hi.myapplication.ui.airport.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hi.myapplication.domain.airport.model.AirportInfoItem


@Composable
fun AirportInfoItem(data: AirportInfoItem, string: String) {
    //U起飛 沒有登機門當作有效資料
    //D降落 有登機門當作有效資料
    //L 用來預覽
    if (((string == "U") and (data.airBoardingGate == "")) or
        ((string == "D") and (data.airBoardingGate != "")) or
        (string == "L")
    ) {
        Spacer(modifier = Modifier.padding(4.dp))

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            border = BorderStroke(
                width = 1.dp,
                color = (if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Column(Modifier.weight(1.0f)) {
                    Row {
                        Time("預估時間", data.expectTime, modifier = Modifier.weight(1.0f))
                        Spacer(modifier = Modifier.padding(8.dp))
                        Time("實際時間", data.realTime, modifier = Modifier.weight(1.0f))
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "航機班號 : ${data.airLineNum}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "登機門 : ${data.airBoardingGate}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "" + data.airFlyStatus,
                        color = colorResource(id = data.status.color),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                }
                Column(
                    Modifier.weight(1.0f)
                ) {
                    Airport(
                        if (data.airBoardingGate.toString() == "") {
                            "U"
                        } else {
                            "D"
                        },
                        data.upAirportCode,
                        data.upAirportName
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(4.dp))
    }
}


@Composable
fun Time(title: String, value: String?, modifier: Modifier) {
    Column(modifier) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(4.dp))
        value?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun Airport(T: String, Code: String?, Name: String?) {
    if (T == "U") {
        AirportDefault()

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "|",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        AirportValue(Code, Name)

    } else {
        AirportValue(Code, Name)

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "|",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        AirportDefault()

    }
}

@Composable
fun AirportDefault() {
    Text(
        "TPE",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.padding(4.dp))

    Text(
        "台北桃園國際機場",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AirportValue(Code: String?, Name: String?) {
    Text(
        Code.toString(),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.padding(4.dp))

    Text(
        Name.toString(),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview
@Composable
private fun LookUi() {
    AirportInfoItem(AirportInfoItem(), "L")
}