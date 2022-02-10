package com.example.tryjackpackcompose.entity.inspection

import com.example.tryjackpackcompose.entity.closeOut.CloseOutRequestItem
import com.example.tryjackpackcompose.entity.followUp.FollowUpItem
import com.example.tryjackpackcompose.entity.image.ImageThumbnail
import com.google.gson.annotations.SerializedName

class InspectionItem {
    @SerializedName("createBy")
    var createBy: String = ""

    @SerializedName("creationDatetime")
    var creationDatetime: String = ""

    @SerializedName("lastUpdateBy")
    var lastUpdateBy: String = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime: String = ""

    @SerializedName("id")
    var id: String = ""

    @SerializedName("code")
    var code: String = ""

    @SerializedName("inspectionDatetime")
    var inspectionDatetime: String = ""

    @SerializedName("hiddenInReport")
    var hiddenInReport: Boolean = false

    @SerializedName("attributes")
    var attributes: InspectionAttribute = InspectionAttribute()

    @SerializedName("projectId")
    var projectId: String = ""

    @SerializedName("followUpItems")
    var followUpItems: List<FollowUpItem> = listOf()

    @SerializedName("closeOutRequestItems")
    var closeOutRequestItems: List<CloseOutRequestItem> = listOf()

    @SerializedName("status")
    var status: String = ""

    @SerializedName("targetCompleteDate")
    var targetCompleteDate: String = ""

    @SerializedName("availableAddressId")
    var availableAddressId: String = ""

    @SerializedName("appInterpret")
    var appInterpret: String = ""

    @SerializedName("createByDisplayName")
    var createByDisplayName: String = ""

    @SerializedName("lastUpdateByDisplayName")
    var lastUpdateByDisplayName: String = ""

    @SerializedName("deleted")
    var deleted = false

    @SerializedName("imageThumbnail")
    var imageThumbnail: List<ImageThumbnail> = listOf()

    @SerializedName("assignedSubConId")
    var assignedSubConId = ""

    @SerializedName("subConAssignedBy")
    var subConAssignedBy = ""

    @SerializedName("subConAssignedTime")
    var subConAssignedTime = ""

    @SerializedName("defaultChecklistItems")
    var defaultChecklistItems: List<ChecklistItem> = listOf()

    @SerializedName("highwayStatus")
    var highwayStatus = ""
}