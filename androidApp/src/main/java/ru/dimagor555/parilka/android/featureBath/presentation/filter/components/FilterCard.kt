package ru.dimagor555.parilka.android.featureBath.presentation.filter.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun FilterCard(
    header: String,
    filters: Set<String>,
    markedFilters: Set<String>,
    icon: ImageVector,
    onClick: (String, Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val rotate = animateFloatAsState(if (expanded) 180f else 0f)
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .animateContentSize()
            .clickable {
                expanded = !expanded
            },
        elevation = 3.dp,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Column() {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FilterIcon(icon)
                    FilterTitle(header, filters.toString().dropLast(1).drop(1))
                }
                FilterButton(rotate)
            }
            if (expanded) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    filters.forEach {
                        val isMarked = markedFilters.contains(it)
                        SelectFilter(it, isMarked, onClick)
                    }
                }
            }
        }
    }
}

@Composable
fun FilterIcon(icon: ImageVector) {
    Icon(
        modifier = Modifier
            .size(40.dp),
        imageVector = icon,
        contentDescription = "",
        tint = MaterialTheme.colors.surface
    )
}

@Composable
fun FilterTitle(header: String, text: String) {
    Column() {
        Text(
            text = header,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun FilterButton(rotate: State<Float>) {
    val circleColor = MaterialTheme.colors.surface.copy(0.5f)
    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(50.dp),
        ) {
            drawCircle(color = circleColor)
        }
        Icon(
            modifier = Modifier
                .size(40.dp)
                .rotate(rotate.value)
                .background(MaterialTheme.colors.surface, CircleShape),
            imageVector = Icons.Rounded.KeyboardArrowDown,
            contentDescription = "",
            tint = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun SelectFilter(text: String, isMarked: Boolean, onClick: (String, Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.primaryVariant),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SelectTitle(text,
            Modifier
                .weight(1f)
                .padding(10.dp))
        SelectButton(Modifier.weight(0.7f).height(45.dp), text, isMarked, onClick)
    }
}

@Composable
fun SelectTitle(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subtitle2
    )
}

@Composable
fun SelectButton(modifier: Modifier, filter: String, isMarked: Boolean, onClick: (String, Boolean) -> Unit, ) {
    val text = if (isMarked) "Отменить" else "Выбрать"
    Button(
        modifier = modifier,
        onClick = {
            onClick(filter, !isMarked)
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor =
            if (isMarked)
                MaterialTheme.colors.error.copy(red = 1f, green = 0.6f, blue = 0.6f)
            else
                MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface,
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}
