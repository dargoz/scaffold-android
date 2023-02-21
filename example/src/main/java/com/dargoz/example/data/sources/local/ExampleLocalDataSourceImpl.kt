package com.dargoz.example.data.sources.local

import android.util.Log
import com.dargoz.example.data.sources.local.dto.OccupationDataRealm
import com.dargoz.example.di.ExampleRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class ExampleLocalDataSourceImpl @Inject constructor(
    @ExampleRealm private val realmConfiguration: RealmConfiguration) : ExampleLocalDataSource {

    override suspend fun saveData(occupationDataRealm: OccupationDataRealm) {
        Log.d("DRG", "save occupations data : ${occupationDataRealm.occupations}")
        val realm = Realm.getInstance(realmConfiguration)
        realm.executeTransaction {
            it.delete(OccupationDataRealm::class.java)
            it.insert(occupationDataRealm)
        }
        realm.close()
    }

    override suspend fun getData(): OccupationDataRealm? {
        val realm = Realm.getInstance(realmConfiguration)
        return realm.where(OccupationDataRealm::class.java).findFirst()
    }
}