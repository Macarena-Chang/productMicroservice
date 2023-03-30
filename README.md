# Product and Coupon Microservices for Discount Management
## (Deployed on AWS, Also Available on Docker)




## Overview
Get discounts on products by using coupon codes. I've built two microservices that work together to make this happen: a product microservice and a coupon microservice.

This project consists of two microservices and a MySQL database. The microservices are deployed on **AWS Elastic Beanstalk** while the database is hosted on **Amazon RDS**.
<br>




### Microservices

 ### Microservice 1: Coupon Microservice
<sup>[repository link](https://github.com/Macarena-Chang/couponMicroservice)</sup>
 This microservice exposes the following endpoints:

 - `/coupons` - POST: Creates a new coupon (all entries in database should have a unique coupon code)
 - `/couponsall` - GET: Get all available coupons
 - `/coupons/{code}` - GET: Retrieve coupon with given code

<br>

> #### Request Examples
> - **POST** `/coupons`
>    ```json
>    {
>        "code": "{code}",
>        "discount": 30,
>        "expDate": "12/12/2024"
>    }
>    ```

### Deployment
Coupon microservice is deployed on AWS Elastic Beanstalk at 
*[`http://Couponmicroservice-env.eba-hsrwim8p.eu-west-1.elasticbeanstalk.com`](`http://Couponmicroservice-env.eba-hsrwim8p.eu-west-1.elasticbeanstalk.com`)*
<br>
<br>

### Microservice 2: Product Microservice  

This microservice exposes the following endpoints:

- `/products` - POST: Creates new product entry and applies any applicable discount based on coupon code provided 

<br>

> #### Request Examples
> - **POST** `/products`
>     ```json
>     {
>         "name":"Corsair VENGEANCE RGB PRO 32GB ",
>         "description": "Corsair VENGEANCE RGB PRO 32GB details.",
>         "price":100,
>         "couponCode": "D15CODE"
>     }
>    ```

### Deployment
Product microservice is deployed on AWS Elastic Beanstalk at 
*[`http://Productmicroservice-env.eba-tx6fajs8.eu-west-1.elasticbeanstalk.com`](`http://Productmicroservice-env.eba-tx6fajs8.eu-west-1.elasticbeanstalk.com`)*

<br>

## Database
Database is available on Amazon RDS
*[`productcouponservice.cgbgpizjxgbf.eu-west-1.rds.amazonaws.com`](`productcouponservice.cgbgpizjxgbf.eu-west-1.rds.amazonaws.com`)*
 

### Tables
#### Coupon table
| id |   code   | discount |  exp_date  |
|:--:|:--------:|:--------:|:----------:|
|  1 | codeName |    50    | 12/12/2025 |

#### Product table
| id |   name   | description |  price  |
|:--:|:--------:|:--------:|:----------:|
|  1 | productName |    product Description    | 45 |

<br>

---
 # Docker
Want to use Dockerized version instead? 
#### Clone repository
`$ git clone https://github.com/Macarena-Chang/couponMicroservice.git`

A [docker-compose.yaml](https://github.com/Macarena-Chang/couponMicroservice/blob/master/docker-compose.yaml) has been provided.

#### Run
```$ docker-compose up         ```

<br>


#### Endpoints:

 - `http://localhost:9091/coupons` - POST: Creates a new coupon (all entries in database should have a unique coupon code)
 - `http://localhost:9091/couponsall` - GET: Get all available coupons
 - `http://localhost:9091/coupons/{code}` - GET: Retrieve coupon with given code

<br>

> #### Request Example
> - **POST** `/coupons`
>    ```json
>    {
>        "code": "{code}",
>        "discount": 30,
>        "expDate": "12/12/2024"
>    }
>    

<br>
<br>

- `http://localhost:9090/products` - POST: Creates new product entry and applies any applicable discount based on coupon code provided 
<br>

> #### Request Examples
> - **POST** `/products`
>     ```json
>     {
>         "name":"Corsair VENGEANCE RGB PRO 32GB ",
>         "description": "Corsair VENGEANCE RGB PRO 32GB details.",
>         "price":100,
>         "couponCode": "D15CODE"
>     }
>    ```

