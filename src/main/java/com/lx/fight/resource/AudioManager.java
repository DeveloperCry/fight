package com.lx.fight.resource;

import com.lx.fight.util.ResourceUtils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.io.IOException;

public class AudioManager {
    byte[] b = new byte[1024 * 1024 * 15];

    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLine_info = null;

    private AudioInputStream audioInputStream = null;

    public AudioManager(String fileName) {
        try {
            audioInputStream = ResourceUtils.getAudio(fileName);
            audioFormat = audioInputStream.getFormat();
            dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loop() {
        try {

            while (true) {
                int len = 0;
                sourceDataLine.open(audioFormat, 1024 * 1024 * 15);
                sourceDataLine.start();
                audioInputStream.mark(12358946);
                while ((len = audioInputStream.read(b)) > 0) {
                    sourceDataLine.write(b, 0, len);
                }
                audioInputStream.reset();

                sourceDataLine.drain();
                sourceDataLine.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            byte[] b = new byte[1024*5];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024*5);
            sourceDataLine.start();
            audioInputStream.mark(12358946);
            while ((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }

            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void close() {
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Audio a = new Audio("audio/explode.wav");
        AudioManager a = new AudioManager("war1.wav");
        a.loop();

    }
}
