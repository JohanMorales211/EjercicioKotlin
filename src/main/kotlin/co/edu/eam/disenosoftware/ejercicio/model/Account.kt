package co.edu.eam.disenosoftware.ejercicio.model

data class Account(
    val id: String,
    val balance: Double,
    val typeEnum: TypeAccountEnum,
)
