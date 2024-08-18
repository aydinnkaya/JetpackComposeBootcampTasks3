package com.aydinkaya.jetpackcomposebootcamptasks3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aydinkaya.jetpackcomposebootcamptasks3.ui.theme.JetpackComposeBootcampTasks3Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBootcampTasks3Theme {
                PorscheTaycanTheme {
                    LoginScreenContent()
                }
            }
        }
    }
}

@Composable
fun PorscheTaycanTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) {
        darkColorScheme(
            primary = colorResource(id = R.color.primary_dark),
            secondary = colorResource(id = R.color.secondary_dark),
            background = colorResource(id = R.color.background_dark),  // Slate Grey for Dark Mode
            surface = colorResource(id = R.color.surface_dark),
            error = colorResource(id = R.color.error_dark),
            onPrimary = colorResource(id = R.color.onPrimary_dark),
            onSecondary = colorResource(id = R.color.onSecondary_dark),
            onBackground = colorResource(id = R.color.onBackground_dark),
            onSurface = colorResource(id = R.color.onSurface_dark)
        )
    } else {
        lightColorScheme(
            primary = colorResource(id = R.color.primary_light),
            secondary = colorResource(id = R.color.secondary_light),
            background = colorResource(id = R.color.background_light),  // Metallic Silver for Light Mode
            surface = colorResource(id = R.color.surface_light),
            error = colorResource(id = R.color.error_light),
            onPrimary = colorResource(id = R.color.onPrimary_light),
            onSecondary = colorResource(id = R.color.onSecondary_light),
            onBackground = colorResource(id = R.color.onBackground_light),
            onSurface = colorResource(id = R.color.onSurface_light)
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            bodyMedium = TextStyle(
                fontSize = 18.sp,
                color = colors.onBackground
            )
        )
    ) {
        content()
    }
}
@Composable
fun LoginScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Porsche Taycan",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            ),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.car_image),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter your email") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter your password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null)
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Log In", color = MaterialTheme.colorScheme.onPrimary)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { /* TODO */ }) {
            Text("Forgot Password?", color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { /* TODO */ }) {
            Text("Create An Account", color = MaterialTheme.colorScheme.primary)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBootcampTasks3Theme {
        PorscheTaycanTheme {
            LoginScreenContent()
        }
    }
}