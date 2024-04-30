package com.honeybadgersoftware.shoplocation.data

class AzureResponseData {

    public static String AzureResponse = '''
{
  "summary": {
    "totalResults": 1,
    "geoBias": {
      "lat": 54.233806,
      "lon": 23.665014
    }
  },
  "results": [
    {
      "dist": 368.776127,
      "poi": {
        "name": "Carrefour Express",
        "brands": [
          {
            "name": "Carrefour Express"
          }
        ]
      }
    }
  ]
}
'''
}
