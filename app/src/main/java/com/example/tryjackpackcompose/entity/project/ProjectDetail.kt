package com.example.tryjackpackcompose.entity.project

import com.example.tryjackpackcompose.entity.inspection.InspectionItem
import com.example.tryjackpackcompose.entity.member.MemberMap
import com.google.gson.annotations.SerializedName

class ProjectDetail {
    @SerializedName("id")
    var id: String = ""

    @SerializedName("companyId")
    var companyId: String = ""

    @SerializedName("title")
    var title: Map<String, String> = mapOf()

    @SerializedName("address")
    var address: Map<String, String> = mapOf()

    @SerializedName("projectNo")
    var projectNo: String = ""

    @SerializedName("completionDate")
    var completionDate: String = ""

    @SerializedName("note")
    var note: String = ""

    @SerializedName("disabled")
    var disabled: Boolean = false

    @SerializedName("createBy")
    var createBy: String = ""

    @SerializedName("creationDatetime")
    var creationDatetime: String = ""

    @SerializedName("lastUpdateBy")
    var lastUpdateBy: String = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime: String = ""

    @SerializedName("member")
    var member: MemberMap = MemberMap()

    @SerializedName("gpsLat")
    var gpsLat: Double = 0.0

    @SerializedName("gpsLon")
    var gpsLon: Double = 0.0

    @SerializedName("predefinedNotes")
    var predefinedNotes: List<String> = listOf()

    @SerializedName("type")
    var type: String = ""

    @SerializedName("subcon")
    var subcon: List<Subcon> = listOf()

    @SerializedName("right")
    var right: ProjectRight = ProjectRight()

    @SerializedName("deleted")
    var deleted: Boolean = false

    @SerializedName("inspectionItems")
    var inspectionItems: List<InspectionItem> = listOf()

    @SerializedName("availableAddresses")
    var availableAddresses: List<AvailableAddress> = listOf()

    @SerializedName("landmarks")
    var landmarks: List<Landmark> = listOf()

    @SerializedName("workTableItems")
    var workTableItems: List<WorkTableItem> = listOf()

    @SerializedName("circulations")
    var circulations: List<Circulation> = listOf()

    @SerializedName("divisions")
    var divisions: List<Division> = listOf()

    @SerializedName("mainConId")
    var mainConId = ""
}