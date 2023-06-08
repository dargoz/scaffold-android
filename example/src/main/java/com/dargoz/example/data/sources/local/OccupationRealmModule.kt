package com.dargoz.example.data.sources.local

import com.dargoz.example.data.sources.local.dto.OccupationDataRealm
import com.dargoz.example.data.sources.local.dto.OccupationRealm
import io.realm.annotations.RealmModule

@RealmModule(
    library = true,
    classes = [OccupationRealm::class, OccupationDataRealm::class]
)
class OccupationRealmModule {
}