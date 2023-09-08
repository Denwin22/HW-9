package ru.netoloygy.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    @Test
    public void shouldSetRadioStationCorrect() {
        for (int i = 0; i <= 9; i++) {
            Radio radio = new Radio();
            radio.setCurrentRadioStation(i);
            int expected = i;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
    }
    @Test
    public void shouldSetRadioStationUnderMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-2);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetRadioStationOverMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(12);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeNextRadioStation() {
        for (int i = 0; i < 9; i++) {
            Radio radio = new Radio();
            radio.setCurrentRadioStation(i);
            radio.nextRadioStation();
            int expected = i+1;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangeNextRadioStationFromMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMaxRadioStation());
        radio.nextRadioStation();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldChangePreviousRadioStation() {
        Radio radio = new Radio();
        for (int i = 1; i < (radio.getMaxRadioStation()); i++) {
            radio.setCurrentRadioStation(i);
            radio.previousRadioStation();
            int expected = i-1;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangePreviousRadioStationFromMinStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMinRadioStation());
        radio.previousRadioStation();
        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentRadioStation(){
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

    }


    // VOLUME
    @Test
    public void shouldChangeVolumeUp() {
        for (int i = 0; i < 100; i++) {
            Radio radio = new Radio();
            radio.setCurrentVolume(i);
            radio.volumeUp();
            int expected = i+1;
            int actual = radio.getCurrentVolume();
            Assertions.assertEquals(expected, actual);
        }
    }
    @Test
    public void shouldChangeVolumeUpFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume());
        radio.volumeUp();
        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeVolumeDown() {
        for (int i = 100; i > 0; i--) {
            Radio radio = new Radio();
            radio.setCurrentVolume(i);
            radio.volumeDown();
            int expected = i-1;
            int actual = radio.getCurrentVolume();
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangeVolumeDownFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume());
        radio.volumeDown();
        int expected = radio.getMinVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentVolume(){
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeUpperMax(){
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetVolumeDownMin(){
        Radio radio = new Radio();
        radio.setCurrentVolume(-2);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationCount (){
        Radio radio = new Radio(26);
        int expected = 25;
        int actual = radio.getMaxRadioStation();
        Assertions.assertEquals(expected, actual);
    }
}