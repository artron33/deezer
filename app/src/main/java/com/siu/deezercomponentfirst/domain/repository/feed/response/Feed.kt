package com.siu.deezercomponentfirst.domain.repository.feed.response

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Feeds")
data class Feed @JvmOverloads constructor (

    @ColumnInfo(name = "Albums") val data : List<Album> = ArrayList<Album>(),
    @PrimaryKey @ColumnInfo(name = "checksum") val checksum : String = "",
    @ColumnInfo(name = "total") val total : Int = 0,
    @ColumnInfo(name = "next") val next : String = "",
    @ColumnInfo(name = "prev") val prev : String = ""
)


data class Album @JvmOverloads constructor (

    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "title") val title : String = "",
    @ColumnInfo(name = "link") val link : String = "",
    @ColumnInfo(name = "cover") val cover : String = "",
    @ColumnInfo(name = "cover_small") val cover_small : String = "",
    @ColumnInfo(name = "cover_medium") val cover_medium : String = "",
    @ColumnInfo(name = "cover_big") val cover_big : String = "",
    @ColumnInfo(name = "cover_xl") val cover_xl : String = "",
    @ColumnInfo(name = "nb_tracks") val nb_tracks : Int = 0,
    @ColumnInfo(name = "release_date") val release_date : String = "",
    @ColumnInfo(name = "record_type") val record_type : String = "",
    @ColumnInfo(name = "available") val available : Boolean = false,
    @ColumnInfo(name = "tracklist") val tracklist : String = "",
    @ColumnInfo(name = "explicit_lyrics") val explicit_lyrics : Boolean = false,
    @ColumnInfo(name = "time_add") val time_add : Int = 0,
    @Embedded val artist : Artist? = Artist(),
    @ColumnInfo(name = "type") val type : String = ""
) : Comparable<Album> {
    override fun compareTo(other: Album): Int {
        return this.id.compareTo(other.id)
    }
}


data class Artist @JvmOverloads constructor (

    @ColumnInfo(name = "id_artist") val id_artist : Int = 0,
    @ColumnInfo(name = "name_artist") val name_artist : String = "",
    @ColumnInfo(name = "picture_artist") val picture_artist : String = "",
    @ColumnInfo(name = "picture_small") val picture_small : String = "",
    @ColumnInfo(name = "picture_medium") val picture_medium : String = "",
    @ColumnInfo(name = "picture_big") val picture_big : String = "",
    @ColumnInfo(name = "picture_xl") val picture_xl : String = "",
    @ColumnInfo(name = "tracklist_artist") val tracklist_artist : String = "",
    @ColumnInfo(name = "type_artist") val type_artist : String = ""
)
/*@field:Json(name = "type") */