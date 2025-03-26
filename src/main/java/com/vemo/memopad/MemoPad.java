package com.vemo.memopad;

import com.vemo.capture.Capture;
import com.vemo.memo.Memo;
import com.vemo.user.User;
import com.vemo.video.Video;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class MemoPad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memopad_id")
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    private Video video;

    @OneToMany(mappedBy = "memoPad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Memo> memos = new ArrayList<>();

    @OneToMany(mappedBy = "memoPad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Capture> captures = new ArrayList<>();

    public MemoPad(
        String title,
        LocalDateTime createdAt,
        User user,
        Video video
    ) {
        this.title = title;
        this.createdAt = createdAt;
        this.user = user;
        this.video = video;
    }

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }
}
