# sitevalidation
SpringBoot, JSoup, Rest

Send put request:
1.
curl -X POST \
  http://localhost:8080/rest/link \
  -H 'Content-Type: application/json' \  
  -H 'cache-control: no-cache' \
  -d '{"site":"www.google.com.ua"}'

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

2. 
curl -X POST \
  http://localhost:8080/rest/html \
  -H 'Content-Type: application/json' \  
  -H 'cache-control: no-cache' \
  -d '{
    "html": "<HTML><HEAD><TITLE>Your Title Here</TITLE></HEAD><BODY BGCOLOR=\"FFFFFF\"><CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER><HR><a href=\"http://somegreatsite.com\">Link Name</a>is a link to another nifty site<H1>This is a Header</H1><H2>This is a Medium Header</H2>Send me mail at <a href=\"mailto:support@yourcompany.com\">support@yourcompany.com</a>.<P> This is a new paragraph!<P> <B>This is a new paragraph!</B><BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B><HR></BODY></HTML>"
}'

answer:

curl -X POST \
  http://localhost:8080/rest/link \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: fdc67cdc-fa62-47df-90ed-d30e1019e829' \
  -H 'cache-control: no-cache' \
  -d '{"site":"www.google.com.ua"}'