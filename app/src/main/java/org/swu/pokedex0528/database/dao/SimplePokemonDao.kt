package org.swu.pokedex0528.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.swu.pokedex0528.model.SimplePokemon

@Dao
interface SimplePokemonDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(pokemon: SimplePokemon): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(poekemonList: List<SimplePokemon>)

    @Query("select * from SimplePokemon where name = :name")
    suspend fun getSimplePokemon(name: String): SimplePokemon

    @Query("select * from SimplePokemon ORDER by id asc LIMIT :limit ")
    suspend fun getAllSimplePokemon(limit:Int): List<SimplePokemon>

    @Query("delete from SimplePokemon")
    suspend fun clearData()

}
