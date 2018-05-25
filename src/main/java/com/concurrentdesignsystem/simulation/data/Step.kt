package com.concurrentdesignsystem.simulation.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "StepCollection")
data class Step(
    @Id val id: String,
    val stepId: Int?,
    val nodes: List<Node>?,
    val elements: List<ElementSolid>?
)