package com.group5.laboratorio3.model

enum class HolidaysEnum(val value: String, val displayableText: String) {
    Christmas("Christmas", "Christmas"),
    Birthday("Birthday", "Birthday"),
    NewYear("NewYear", "New Year"),
    Wedding("Wedding", "Wedding"),
    Graduation("Graduation", "Graduation");

    companion object {
        fun byNameOrNull(input: String): HolidaysEnum? {
            return values().firstOrNull { it.name == input }
        }
    }
}