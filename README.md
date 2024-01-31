功能:

- 每日 18:00 呼叫來源 API 取得外匯成交資料, 並將美元兌台幣資料與日期儲存至 DB

- 使用 API 查詢已儲存的外匯歷史資料

Method: 
```
POST
```

API: 
```
/forex/v1/DailyForeignExchangeRates
```

Parameters: 
```json
{
  "startDate": "string",
  "endDate": "string",
  "currency": "string",
}
```

Success:
```json
{
  "error": {
    "code": "string",
    "message": "string"
  },
  "currency": [
    {
      "date": "string",
      "usd": "string",
    }
  ]
}
```

Failed:
```json
{
  "error": {
    "code": "string",
    "message": "string",
  }
}
```
---
Example: 

API request:
```json
{
  "startDate": "2024/01/29",
  "endDate": "2024/01/30",
  "currency": "usd"
}
```

API response:
```json
{
  "error": {
    "code": "0000",
    "message": "成功"
  },
  "currency": [
    {
      "date": "20240129",
      "usd": "31.253"
    },
    {
      "date": "20240130",
      "usd": "31.162"
    }
  ]
}
```
