package com.dargoz.example.data.sources.local.dto

import io.realm.RealmList
import io.realm.RealmObject

open class OccupationRealm (
    var code : String = "",
    var group: String = "",
    var position: String? = null,
    var subOccupations : RealmList<OccupationRealm>? = null
        ) : RealmObject()