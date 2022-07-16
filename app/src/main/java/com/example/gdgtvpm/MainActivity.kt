package com.example.gdgtvpm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.gdgtvpm.ui.theme.GDGTvpmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDGTvpmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {

                        for (m in movies) {
                            item {
                                MovieItem(name = m.title, synopsis = m.plot, url = m.poster)
                            }
                        }


                    }

                }
            }
        }
    }
}


@Composable
fun MovieItem(name: String, synopsis: String, url: String) {

    var showDetails by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding()
            .border(2.dp, Color.Red, RoundedCornerShape(6.dp))
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = rememberAsyncImagePainter(url),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                name,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )

            Button(onClick = {
                showDetails = !showDetails
            }) {
                Text(
                    if (showDetails) "Hide Details" else "Show Details"
                )
            }

        }

        if (showDetails) {
            Text(synopsis)
        }


    }

}


data class Movie(
    val title: String,
    val year: String,
    val runtime: String,
    val director: String,
    val plot: String,
    val poster: String,
    val imdbRating: String,
)

val movies = listOf(
    Movie(
        "Avatar",
        "2009",
        "162 min",
        "James Cameron",
        "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        "https://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg",
        "7.9"
    ),
    Movie(
        "I Am Legend",
        "2007",
        "101 min",
        "Francis Lawrence",
        "Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MDM1OTU5OV5BMl5BanBnXkFtZTYwMjA0Nzc4._V1_.jpg",
        "7.2"
    ),
    Movie(
        "300",
        "2006",
        "117 min",
        "Zack Snyder",
        "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.",
        "https://ia.media-imdb.com/images/M/MV5BMjAzNTkzNjcxNl5BMl5BanBnXkFtZTYwNDA4NjE3._V1_SX300.jpg",
        "7.7"
    ),
    Movie(
        "The Avengers",
        "2012",
        "143 min",
        "Joss Whedon",
        "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
        "https://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SX300.jpg",
        "8.1"
    ),
    Movie(
        "The Wolf of Wall Street",
        "2013",
        "180 min",
        "Martin Scorsese",
        "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
        "https://ia.media-imdb.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SX300.jpg",
        "8.2"
    ),
    Movie(
        "Interstellar",
        "2014",
        "169 min",
        "Christopher Nolan",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        "https://ia.media-imdb.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg",
        "8.6"
    ),
    Movie(
        "Game of Thrones",
        "2011–",
        "56 min",
        "N/A",
        "While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.",
        "https://ia.media-imdb.com/images/M/MV5BMjM5OTQ1MTY5Nl5BMl5BanBnXkFtZTgwMjM3NzMxODE@._V1_SX300.jpg",
        "9.5"
    ),
    Movie(
        "Vikings",
        "2013–",
        "44 min",
        "N/A",
        "The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.",
        "https://ia.media-imdb.com/images/M/MV5BOTEzNzI3MDc0N15BMl5BanBnXkFtZTgwMzk1MzA5NzE@._V1_SX300.jpg",
        "8.6"
    ),
    Movie(
        "Gotham",
        "2014–",
        "42 min",
        "N/A",
        "The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival.",
        "https://ia.media-imdb.com/images/M/MV5BMTY2MjMwNDE4OV5BMl5BanBnXkFtZTgwNjI1NjU0OTE@._V1_SX300.jpg",
        "8.0"
    ),
    Movie(
        "Power",
        "2014–",
        "50 min",
        "N/A",
        "James \"Ghost\" St. Patrick, a wealthy New York night club owner who has it all, catering for the city's elite and dreaming big, lives a double life as a drug kingpin.",
        "https://ia.media-imdb.com/images/M/MV5BOTA4NTkzMjUzOF5BMl5BanBnXkFtZTgwNzg5ODkxOTE@._V1_SX300.jpg",
        "8.0"
    ),
    Movie(
        "Narcos",
        "2015–",
        "49 min",
        "N/A",
        "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.",
        "https://ia.media-imdb.com/images/M/MV5BMTU0ODQ4NDg2OF5BMl5BanBnXkFtZTgwNzczNTE4OTE@._V1_SX300.jpg",
        "8.9"
    ),
    Movie(
        "Breaking Bad",
        "2008–2013",
        "49 min",
        "N/A",
        "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's financial future.",
        "https://ia.media-imdb.com/images/M/MV5BMTQ0ODYzODc0OV5BMl5BanBnXkFtZTgwMDk3OTcyMDE@._V1_SX300.jpg",
        "9.5"
    ),
    Movie(
        "Doctor Strange",
        "2016",
        "N/A",
        "Scott Derrickson",
        "After his career is destroyed, a brilliant but arrogant and conceited surgeon gets a new lease on life when a sorcerer takes him under her wing and trains him to defend the world against evil.",
        "https://ia.media-imdb.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg",
        "N/A"
    ),
    Movie(
        "Rogue One: A Star Wars Story",
        "2016",
        "N/A",
        "Gareth Edwards",
        "The Rebellion makes a risky move to steal the plans to the Death Star, setting up the epic saga to follow.",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQyMzI2OTA3OF5BMl5BanBnXkFtZTgwNDg5NjQ0OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
        "N/A"
    ),
    Movie(
        "Assassin's Creed",
        "2016",
        "N/A",
        "Justin Kurzel",
        "When Callum Lynch explores the memories of his ancestor Aguilar and gains the skills of a Master Assassin, he discovers he is a descendant of the secret Assassins society.",
        "https://ia.media-imdb.com/images/M/MV5BMTU2MTQwMjU1OF5BMl5BanBnXkFtZTgwMDA5NjU5ODE@._V1_SX300.jpg",
        "N/A"
    ),
    Movie(
        "Luke Cage",
        "2016–",
        "55 min",
        "N/A",
        "Given superstrength and durability by a sabotaged experiment, a wrongly accused man escapes prison to become a superhero for hire.",
        "https://ia.media-imdb.com/images/M/MV5BMTcyMzc1MjI5MF5BMl5BanBnXkFtZTgwMzE4ODY2OTE@._V1_SX300.jpg",
        "N/A"
    ),
)