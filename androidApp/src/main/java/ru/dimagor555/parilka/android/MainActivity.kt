package ru.dimagor555.parilka.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.dimagor555.parilka.android.featureBath.coin.bathPresentationModule
import ru.dimagor555.parilka.android.featureBath.ui.theme.ParilkaTheme
import ru.dimagor555.parilka.android.navigation.AppNavigationFlow
import ru.dimagor555.parilka.bath.data.bathDataModule

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(bathDataModule, bathPresentationModule)
        }
        setContent {
            ParilkaTheme {
                AppNavigationFlow()
            }
        }
    }
}


