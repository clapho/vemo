package com.vemo.playlist;

import com.vemo.video.Video;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PlaylistVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    protected PlaylistVideo() {
    }

    public PlaylistVideo(Playlist playlist, Video video) {
        this.playlist = playlist;
        this.video = video;
    }
}
