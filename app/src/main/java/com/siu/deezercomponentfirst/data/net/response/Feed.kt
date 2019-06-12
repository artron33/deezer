package com.siu.deezercomponentfirst.data.net.response


data class Feed @JvmOverloads constructor (

    val data : List<Album> = ArrayList(),
    val checksum : String = "",
    val total : Int = 0,
    val next : String = "",
    val prev : String = ""
)


data class Album @JvmOverloads constructor (

    val id : Int = 0,
    val title : String = "",
    val link : String = "",
    val cover : String = "",
    val cover_small : String = "",
    val cover_medium : String = "",
    val cover_big : String = "",
    val cover_xl : String = "",
    val nb_tracks : Int = 0,
    val release_date : String = "",
    val record_type : String = "",
    val available : Boolean = false,
    val tracklist : String = "",
    val explicit_lyrics : Boolean = false,
    val time_add : Int = 0,
    val artist : Artist? = Artist(),
    val type : String = ""

) : Comparable<Album> {

    override fun compareTo(other: Album): Int {
        return this.id.compareTo(other.id)
    }
}


data class Artist @JvmOverloads constructor (

    val id_artist : Int = 0,
    val name_artist : String = "",
    val picture_artist : String = "",
    val picture_small : String = "",
    val picture_medium : String = "",
    val picture_big : String = "",
    val picture_xl : String = "",
    val tracklist_artist : String = "",
    val type_artist : String = ""
)
/*@field:Json(name = "type") */