class Song(val title: String, val artist: String, val duration: Int) {
    fun play() {
        println("Now playing: $title by $artist. Duration: $duration seconds.")
    }
}

fun filterByArtist(songs: List<Song>, artist: String): List<Song> {
    return songs.filter { it.artist == artist }
}


class DuplicateSongException(message: String) : Exception(message)

class Playlist {
    var songs = mutableListOf<Song>()

    fun addSong(song: Song) {
        val isDuplicate = songs.any { existingSong -> existingSong.title == song.title }

        if (isDuplicate) {
            throw DuplicateSongException("Song '${song.title}' is already in the playlist.")
        } else {
            songs.add(song)
            println("Song '${song.title}' added to the playlist.")
        }
    }

}

fun main() {
    val songs = mutableListOf<Song>()
    songs.add(Song("Song 1", "Artist 1", 180))
    songs.add(Song("Song 2", "Artist 2", 240))
    songs.add(Song("Song 3", "Artist 1", 200))
    songs.add(Song("Song 4", "Artist 3", 210))
    songs.add(Song("Song 5", "Artist 2", 220))

    println("Songs list:")
    for (song in songs) {
        println("Songname: ${song.title}  Artist: ${song.artist}  Duration: ${song.duration}")
    }

    println("Enter artist name to filter:")
    val artistName = readLine()
    val filteredSongs = artistName?.let { filterByArtist(songs, it) }
    println("Filtered songs:")
    if (filteredSongs != null) {
        for (song in filteredSongs) {
            println("${song.title} by ${song.artist}")
        }
    }
    var s=Song("Song 1", "Artist 1", 180)
    s.play()
    val playlist = Playlist()
    playlist.songs = songs
    println("Enter how many songs to add")
    var num:Int=Integer.valueOf(readLine())
    for(i in 1..num) {
        println("Enter title name")
        var title = readln()
        println("Enter artist name")
        var artist = readln()
        println("Enter duration")
        var duration: Int = Integer.valueOf(readLine())
        var s1 = Song(title, artist, duration)

    try {
        playlist.addSong(s1)

    } catch (e: DuplicateSongException) {
        println("Error: ${e.message}")

    }
    }
}
