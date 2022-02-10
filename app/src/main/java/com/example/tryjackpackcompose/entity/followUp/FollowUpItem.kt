package com.example.tryjackpackcompose.entity.followUp

import com.example.tryjackpackcompose.entity.image.ImageThumbnail
import com.google.gson.annotations.SerializedName

class FollowUpItem {
    @SerializedName("id")
    var id: String = ""

    @SerializedName("reportedTime")
    var reportedTime = ""

    @SerializedName("percentageToComplete")
    var percentageToComplete = 0

    @SerializedName("notes")
    var notes = ""

    @SerializedName("beingAffected")
    var beingAffected = false

    @SerializedName("user")
    var user = ""

    @SerializedName("imageThumbnail")
    var imageThumbnail: List<ImageThumbnail> = listOf()

    @SerializedName("checklist_items")
    var checklist_items = ""

    @SerializedName("created")
    var created = ""

    @SerializedName("highway_role")
    var highway_role = ""

    @SerializedName("hyd_id")
    var hyd_id = 0

    @SerializedName("inspection_item_id")
    var inspection_item_id = ""

    @SerializedName("modified")
    var modified = ""

    @SerializedName("project_id")
    var project_id = ""

    @SerializedName("requested_by")
    var requested_by = ""
}