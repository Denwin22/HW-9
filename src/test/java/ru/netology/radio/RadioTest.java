package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.security.PublicKey;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    public void inputRadioWave() {
        Radio radio = new Radio(20);
        Assertions.assertEquals(19, radio.getMaxRadioWave());
        Assertions.assertEquals(0, radio.getMinRadioWave());
        Assertions.assertEquals(0, radio.getCurrentRadioWave());
    }
    @Test
    public void inputNegativeRadioWave() {
        Radio radio = new Radio(-20);
        Assertions.assertEquals(0, radio.getMaxRadioWave());
        Assertions.assertEquals(0, radio.getMinRadioWave());
        Assertions.assertEquals(0, radio.getCurrentRadioWave());
    }
    @Test
    public void nextRadioWaveIfMax() {
        Radio radio = new Radio(11);
        radio.setCurrentRadioWave(10);
        radio.setNextRadioWave();

        int expected = 0;
        int actual = radio.getCurrentRadioWave();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void nextRadioWaveIfMin() {
        Radio radio = new Radio(33);
        radio.setCurrentRadioWave(0);
        radio.setNextRadioWave();

        int expected = 1;
        int actual = radio.getCurrentRadioWave();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void prevRadioWaveIfMin() {
        Radio radio = new Radio(51);
        radio.setCurrentRadioWave(0);
        radio.setPrevRadioWave();

        int expected = 50;
        int actual = radio.getCurrentRadioWave();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void prevRadioWaveIfMax() {
        Radio radio = new Radio(40);
        radio.setCurrentRadioWave(39);
        radio.setPrevRadioWave();

        int expected = 38;
        int actual = radio.getCurrentRadioWave();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void increaseSoundLevelIfMax() {
        Radio radio = new Radio();
        radio.setCurrentSoundLevel(100);
        radio.increaseSoundLevel();

        int expected = 100;
        int actual = radio.getCurrentSoundLevel();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void increaseSoundLevelIfMin() {
        Radio radio = new Radio();
        radio.setCurrentSoundLevel(0);
        radio.increaseSoundLevel();

        int expected = 1;
        int actual = radio.getCurrentSoundLevel();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void decreaseSoundLevelIfMin() {
        Radio radio = new Radio();
        radio.setCurrentSoundLevel(0);
        radio.decreaseSoundLevel();

        int expected = 0;
        int actual = radio.getCurrentSoundLevel();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void decreaseSoundLevelIfMax() {
        Radio radio = new Radio();
        radio.setCurrentSoundLevel(100);
        radio.decreaseSoundLevel();

        int expected = 99;
        int actual = radio.getCurrentSoundLevel();

        Assertions.assertEquals(expected, actual);
    }
}