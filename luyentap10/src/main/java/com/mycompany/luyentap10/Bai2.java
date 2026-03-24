package com.mycompany.luyentap10;

interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("--- Đang phát file VLC: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
   
    VlcPlayer vlcPlayer = new VlcPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("--- Đang phát file MP3: " + fileName);
        } else {
            System.out.println("--- Định dạng " + audioType + " không hỗ trợ.");
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH ADAPTER PATTERN ===");
        
        MediaAdapter myPlayer = new MediaAdapter();

        myPlayer.play("mp3", "nhac_tre.mp3");
        
        myPlayer.play("vlc", "phim_hanh_dong.vlc");
        
        myPlayer.play("mp4", "video_clip.mp4");
    }
}