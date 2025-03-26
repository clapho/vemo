package com.vemo.channel;

import com.vemo.video.Video;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Channel {

    @Id
    @Column(length = 24, nullable = false)
    private String id;

    @Column(length = 255, nullable = false)
    private String thumbnails;

    @Column(length = 100, nullable = false)
    private String title;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();
}
