package com.ebenezer.gana.shoppy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ebenezer.gana.shoppy.ui.theme.MyTheme
import com.ebenezer.gana.shoppy.ui.theme.specialColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UsersApplication()

            }
        }
    }


}

@Composable
fun UsersApplication(products: List<Products> = productsList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "products_list") {

        composable("products_list") {
            ProductsList(products, navController)
        }
        composable(
            route = "product_details/{productId}",

            arguments = listOf(navArgument("productId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            ProductsDetails(navBackStackEntry.arguments!!.getInt("productId"),
            navController = navController)

        }
    }
}


@Composable
fun ProductsList(products: List<Products>, navController: NavHostController?) {
    Scaffold(topBar = {
        AppBar(
            title = "Products List",
            icon = Icons.Default.ShoppingCart
        ) { }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn() {
                items(products) { product ->
                    ItemCard(product = product) {
                        navController?.navigate("product_details/${product.id}")
                    }

                }
            }


        }

    }

}


@Composable
fun ProductsDetails(
    productId: Int,
    navController: NavHostController?
) {
    val product = productsList.first { product -> productId == product.id }


    Scaffold(topBar = {
        AppBar(
            title = "Product Details",
            icon = Icons.Default.ArrowBack
        ) {
            navController?.navigateUp()
        }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                ProductImage(product.imageUrl, 300.dp)
                ProductContent(product.productName, product.productDescription,
                Alignment.CenterHorizontally)
            }


        }

    }

}


@Composable
fun AppBar(title: String, icon: ImageVector, onClick: () -> Unit) {
    TopAppBar(navigationIcon = {
        Icon(
            icon,
            contentDescription = "Home",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .size(30.dp)
                .clickable { onClick.invoke() }

        )
    },
        title = { Text(text = title) })
}

@Composable
fun ItemCard(product: Products, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable { onClick.invoke() },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ProductImage(product.imageUrl, 72.dp)
            ProductContent(product.productName, product.productDescription, Alignment.Start)
        }


    }
}

@Composable
fun ProductContent(
    productName: String,
    productDescription: String,
    alignment: Alignment.Horizontal
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment



    ) {
        Text(text = productName, style = MaterialTheme.typography.h5)


        Text(text = productDescription, style = MaterialTheme.typography.body1)
    }


}

@Composable
fun ProductImage(pictureUrl: String, imageSize: Dp) {
    Card(
        border = BorderStroke(1.dp, color = MaterialTheme.colors.specialColor),
        shape = RectangleShape,
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pictureUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Profile picture description",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(imageSize),
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ProductDetailsListPreview() {
    MyTheme {
        ProductsDetails(productId = 0, null)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsListPreview() {
    MyTheme {
        ProductsList(products = productsList, null)
    }
}