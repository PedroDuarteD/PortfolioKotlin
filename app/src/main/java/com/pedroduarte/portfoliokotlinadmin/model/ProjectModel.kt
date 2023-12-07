package com.pedroduarte.portfoliokotlinadmin.model

data class ProjectModel (
    val id: Int,
    val nome: String,
    val desc: String,
    val os: String,
    val enable: Boolean,
) {
}