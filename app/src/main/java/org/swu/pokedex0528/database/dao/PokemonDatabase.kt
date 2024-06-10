package org.swu.pokedex0528.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.swu.pokedex0528.model.SimplePokemon

@Database(entities = arrayOf(SimplePokemon::class), version = 1)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun simplePokemonDao(): SimplePokemonDao

    companion object {
        @Volatile
        private var instance: PokemonDatabase? = null

        private const val DATABASE_NAME = "pokemonDatabase"

        operator fun invoke(context: Context) =
            instance
                ?: synchronized(this) {
                    instance
                        ?: buildDatabase(
                            context
                        ).also {
                            instance = it
                        }
                }

        private fun buildDatabase(context: Context): PokemonDatabase {
            return Room.databaseBuilder(
                context,
                PokemonDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}