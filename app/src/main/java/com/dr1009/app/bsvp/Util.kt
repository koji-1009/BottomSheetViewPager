package com.dr1009.app.bsvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)

class SimpleViewHolder<T : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
    val binding: T? = DataBindingUtil.bind(view)
}

@BindingAdapter("date")
fun TextView.bindDate(date: LocalDate?) {
    if (date == null) {
        text = ""
        return
    }

    text = date.formatLongStyle()
}

fun LocalDate.formatLongStyle(): String =
    FORMATTER_LOCALIZED_DATE_LONG.format(this)

val FORMATTER_LOCALIZED_DATE_LONG: DateTimeFormatter =
    DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
