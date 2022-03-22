package com.ebenezer.gana.shoppy

data class Products(
    val id: Int,
    val productName: String,
    val productDescription: String,
    val imageUrl: String
)

val productsList = arrayListOf(
    Products(
        id = 1,
        productName = "Google Home",
        productDescription = "Enjoy Amazing sounds",
        "https://images.unsplash.com/photo-1567466061910-46fdb3bc18b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=415&q=80"
    ),
    Products(
        id = 2,
        productName = "Speaker",
        productDescription = "Boom Boom Boom. Let it boom your life",
        "https://images.unsplash.com/photo-1528310385748-dba09bf1657a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=409&q=80"
    ),
    Products(
        id = 3,
        productName = "Head Phone",
        productDescription = "Head Phone",
        "https://media.istockphoto.com/photos/3d-rendering-picture-id1320885040?k=20&m=1320885040&s=612x612&w=0&h=Y8tj5N9a7o5gv52gmEqO7TxBlKmjNbc4_O0pzVkDfX4="
    ),
    Products(
        id = 4,
        productName = "Circuit board",
        productDescription = "Green computer circuit board",
        "https://images.pexels.com/photos/159220/printed-circuit-board-print-plate-via-macro-159220.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 5,
        productName = "Digital Camera",
        productDescription = "Black DSLR camera",
        "https://images.pexels.com/photos/51383/photo-camera-subject-photographer-51383.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 6,
        productName = "CPU",
        productDescription = "Dell motherboard and central processing unit",
        "https://images.pexels.com/photos/1432675/pexels-photo-1432675.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 7,
        productName = "Robot",
        productDescription = "Photo of a robot",
        "https://images.pexels.com/photos/2599244/pexels-photo-2599244.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 8,
        productName = "Drone",
        productDescription = "Flying white drone tilt shift lens photography",
        "https://images.pexels.com/photos/1087180/pexels-photo-1087180.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 9,
        productName = "iPhone",
        productDescription = "iPhone 7 on a brown table",
        "https://images.pexels.com/photos/699122/pexels-photo-699122.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 10,
        productName = "Xbox Game Controller",
        productDescription = "Black Microsoft xbox game controller",
        "https://images.pexels.com/photos/1298601/pexels-photo-1298601.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 11,
        productName = "Apple Watch",
        productDescription = "Rose gold aluminum case apple watch with white sports and band",
        "https://images.pexels.com/photos/393047/pexels-photo-393047.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Products(
        id = 12,
        productName = "Black Laptop Computer",
        productDescription = "Black laptop computer",
        "https://images.pexels.com/photos/1229861/pexels-photo-1229861.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
)
