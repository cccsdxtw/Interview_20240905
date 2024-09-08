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
                        Column(modifier = Modifier.weight(1.0f)) {
                            Text(
                                text = "預計時間",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            data.expectTime?.let {
                                Text(
                                    text = it,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(modifier = Modifier.weight(1.0f)) {
                            Text(
                                text = "實際時間",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            data.realTime?.let {
                                Text(
                                    text = it,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
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
                    data.upAirportCode?.let {
                        Text(
                            text = if (data.airBoardingGate == "") {
                                it
                            } else
                                "TPE",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    data.upAirportName?.let {
                        Text(
                            text = if (data.airBoardingGate == "") {
                                it
                            } else
                                "台北桃園國際機場",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "|",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    data.upAirportCode?.let {
                        Text(
                            text = if (data.airBoardingGate == "") {
                                "TPE"
                            } else
                                it,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    data.upAirportName?.let {
                        Text(
                            text = if (data.airBoardingGate == "") {
                                "台北桃園國際機場"
                            } else
                                it,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    } else {
        Card() {}
    }

}


@Preview
@Composable
private fun Test() {
    AirportInfoItem(AirportInfoItem(), "L")
}