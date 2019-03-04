# sitevalidation
SpringBoot, JSoup, Rest

Send put request:

curl -X POST \
  http://localhost:8080/rest \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \ 
  -d '{"site":"http://www.create.com.ua/"}
'

Answer:

{
    "emails": [
        "info@mart.com.ua"
    ],
    "HREFs": {
        "errorsSites": [
            {
                "uri": " find with Error message Must supply a valid URL",
                "responceCode": 500
            },
            {
                "uri": "mailto:info@mart.com.ua find with Error message Only http & https protocols supported",
                "responceCode": 500
            }
        ],
        "validSites": [
            {
                "uri": "https://mart.com.ua/services/corporative-websites/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/services/technical-optimization/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/portfolio/sites/2019/lending-na-tilde-dlja-rockstartatoo-studio/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/services/branding-and-design/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/contacts/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/services/online-shops/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/portfolio/sites/2018/stoles/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/studio/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/portfolio/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/portfolio/sites/2018/witec5/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/services/promotion-and-advertising/",
                "responceCode": 200
            },
            {
                "uri": "https://t.me/MartStudio",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/",
                "responceCode": 200
            },
            {
                "uri": "https://mart.com.ua/services/",
                "responceCode": 200
            },
            {
                "uri": "https://www.facebook.com/mart.com.ua",
                "responceCode": 200
            }
        ]
    }
