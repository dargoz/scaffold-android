package com.dargoz.example.data.sources.local.dto

import io.realm.RealmList
import io.realm.RealmObject

open class OccupationDataRealm(
    val occupations: RealmList<OccupationRealm> = RealmList()
) : RealmObject()