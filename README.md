# shopping-cart


Use swagger to post requests:
http://localhost:8800/swagger-ui.html#/


>Add Customer request:
```{
  "name": "param",
  "address": {
    "addressLine": "address line 1",
    "city": "bangalore",
    "state": "ka",
    "pinCode": 560076
  }
}

>Add Items to catalog:

```{
  "catalogItems": [
    {
      "sku": "sku-1",
      "category": "BOOK",
      "price": 20.10,
      "title": "Title1",
      "author": "author1"
    },
    {
      "sku": "sku-2",
      "category": "BOOK",
      "price": 30.30,
      "title": "Title2",
      "author": "author2"
    },
    {
      "sku": "sku-3",
      "category": "BOOK",
      "price": 40.10,
      "title": "Title3",
      "author": "author3"
    }
    
  ]
}




