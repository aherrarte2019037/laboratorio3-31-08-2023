package com.group5.laboratorio3.model

enum class DesignsEnum(val value: String, val displayableText: String) {
    Cartoon("Cartoon","Cartoon"),
    Elegant("Elegant","Elegant"),
    Minimalist("Minimalist","Minimalist"),
    Retro("Retro", "Retro");

    companion object {
        fun byNameOrNull(input: String): DesignsEnum? {
            return DesignsEnum.values().firstOrNull { it.name == input }
        }
    }
}