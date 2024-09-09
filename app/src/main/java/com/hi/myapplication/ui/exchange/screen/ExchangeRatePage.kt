//匯率的每一條

package com.hi.myapplication.ui.exchange.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hi.myapplication.R
import com.hi.myapplication.domain.exchange.model.RateInfoItem
import com.hi.myapplication.ui.exchange.ExchangeRateViewModel
import com.hi.myapplication.ui.exchange.screen.caculatorView.BottomSheetCalculator
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeRatePage(model: ExchangeRateViewModel = hiltViewModel()) {
    val allRateName = RateInfoItem.Data.getCurrencies()
    val bottomSheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectItemName by remember {
        mutableStateOf("USD")
    }
    val displayList = model.displayList.collectAsState()
    val isCardEnable = model.isRateCardEnabled.collectAsState()
    val lazyListState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.padding(10.dp))
        }
        items(allRateName) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .then(
                        if (isCardEnable.value) {
                            Modifier.clickable {
                                showBottomSheet = true
                                selectItemName = it
                                scope.launch {
                                    lazyListState.animateScrollToItem(index = allRateName.indexOf(it))
                                }
                            }
                        } else {
                            Modifier
                        }
                    ),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Text(
                        //選到會變成 colorResource(R.color.purple_500)
                        color =  if(selectItemName.uppercase() == it.uppercase()){
                            colorResource(R.color.purple_500)
                        }else
                            MaterialTheme.colorScheme.secondary,
                        text = it.uppercase(),
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                    Text(
                        text = displayList.value[it.lowercase()].toString(),
                        Modifier
                            .weight(1.0f)
                            .padding(8.dp),
                        textAlign = TextAlign.Right,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.padding(32.dp),
            sheetState = bottomSheetState,
            onDismissRequest = { showBottomSheet = false }
        ) {
            BottomSheetCalculator(selectItemName, model)
        }
    }
}

