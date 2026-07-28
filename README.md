# cathaybk_test_flightAndExchangeRates (20240905)

航班與匯率查詢 App。底部導航切換「航班」與「匯率」兩大功能：航班以示範班表資料呈現起飛／抵達資訊；匯率串接 [FreeCurrencyAPI](https://freecurrencyapi.com/)，並內建計算機做多幣別換算。以 Jetpack Compose 實作，架構為 MVVM + Hilt。

> **GitHub About 建議文案**  
> 航班與匯率查詢 App｜Kotlin · Compose · MVVM · Hilt · Retrofit，航班班表展示與 FreeCurrencyAPI 匯率換算

---

## 功能

### 航班

- 底部導航進入航班頁，上方 Tab 切換「起飛班機」／「抵達班機」（HorizontalPager）
- 卡片顯示預估／實際時間、航機班號、登機門、航班狀態與對應機場
- 狀態依文字對應顏色（抵達、準時、未知）
- 下拉重新整理（Pull to Refresh）
- 目前使用內嵌 JSON 示範資料（格式對齊機場公開班表）；Airport API／Retrofit 介面已預留，尚未接上正式 API

### 匯率

- 啟動時透過 FreeCurrencyAPI 取得最新匯率
- 列表顯示 JPY、USD、CNY、EUR、AUD、KRW
- 點擊幣別開啟 Bottom Sheet 計算機，輸入金額後即時換算其他貨幣

---

## 資料來源

| 功能 | 來源 | 說明 |
| --- | --- | --- |
| 航班 | 內嵌示範 JSON | 欄位風格對齊機場公開班表（如預估／實際時間、航司、登機門、狀態） |
| 匯率 | `https://api.freecurrencyapi.com/v1/latest` | Header 帶入 `apiKey`；回傳多幣別對美元匯率後再交叉換算 |

---

## 技術架構

- **語言**：Kotlin
- **UI**：Jetpack Compose + Material 3
- **架構**：MVVM（UI / ViewModel / UseCase / Repository）
- **DI**：Hilt
- **網路**：Retrofit + Gson
- **非同步**：Kotlin Coroutines + Flow
- **其他**：Coil（圖片）、Navigation / Bottom Navigation

```
app/src/main/java/com/hi/myapplication/
├── data/
│   ├── airport/     # 航班 API／Repository（API 介面預留）
│   └── exchange/    # 匯率 Retrofit、Repository
├── domain/
│   ├── airport/     # 航班 model、UseCase
│   └── exchange/    # 匯率 model、換算 UseCase
├── module/          # Hilt Module（Network、App）
├── ui/
│   ├── airport/     # 航班頁、ViewModel、卡片元件
│   ├── exchange/    # 匯率頁、計算機 Bottom Sheet
│   ├── navigationbar/
│   └── theme/
├── MainActivity.kt
└── MyApplication.kt
```

---

## 環境需求

- Android Studio Ladybug 或更新版本
- JDK 17 建議（專案亦設定 Java 8 bytecode）
- minSdk 34 / targetSdk 34 / compileSdk 34
- 匯率功能需可連線至 `api.freecurrencyapi.com`

---

## 建置與執行

```bash
./gradlew :app:assembleDebug
```

或於 Android Studio 開啟專案後，直接 Run `app`。

產出 APK 位於 `app/build/outputs/apk/debug/`。

---

## 面試實作重點

此專案作為面試作品，重點展示：

- Kotlin + Jetpack Compose 介面實作
- MVVM 分層與 UseCase 整理資料邏輯
- Hilt 依賴注入與 Retrofit 網路串接
- 航班列表 UI／狀態呈現與匯率換算互動

---

## 授權

未指定授權條款。若要公開釋出，請自行補上 LICENSE。
