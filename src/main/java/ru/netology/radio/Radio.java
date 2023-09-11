package ru.netology.radio;

public class Radio {
    private int maxRadioWave;
    private int minRadioWave;
    private int currentRadioWave = minRadioWave;
    private int maxSoundLevel = 100;
    private int minSoundLevel = 0;
    private int currentSoundLevel = minSoundLevel;

    public Radio() {
        maxRadioWave = 9;
        minRadioWave = 0;
    }

    public Radio(int stationCount) {
        maxRadioWave = stationCount - 1;
        if (stationCount < 0) {
            maxRadioWave = currentRadioWave;
        }
    }

    public int getMaxRadioWave() {
        return maxRadioWave;
    }

    public int getMinRadioWave() {
        return minRadioWave;
    }

    public int getCurrentRadioWave() {
        return currentRadioWave;
    }

    public int getCurrentSoundLevel() {
        return currentSoundLevel;
    }

    public void setCurrentRadioWave(int newCurrentRadioWave) {
        if (newCurrentRadioWave < minRadioWave) {
            currentRadioWave = minRadioWave;
            return;
        }
        if (newCurrentRadioWave > maxRadioWave) {
            currentRadioWave = minRadioWave;
            return;
        }
        currentRadioWave = newCurrentRadioWave;
    }

    public void setNextRadioWave() {
        if (currentRadioWave == maxRadioWave) {
            currentRadioWave = minRadioWave;
        } else {
            currentRadioWave++;
        }
    }

    public void setPrevRadioWave() {
        if (currentRadioWave == minRadioWave) {
            currentRadioWave = maxRadioWave;
        } else {
            currentRadioWave--;
        }
    }

    public void increaseSoundLevel() {
        if (currentSoundLevel < maxSoundLevel) {
            currentSoundLevel = currentSoundLevel + 1;
        }
    }

    public void decreaseSoundLevel() {
        if (currentSoundLevel > minSoundLevel) {
            currentSoundLevel = currentSoundLevel - 1;
        }
    }

    public void setCurrentSoundLevel(int newCurrentSoundLevel) {
        if (newCurrentSoundLevel > maxSoundLevel) {
            return;
        }
        if (newCurrentSoundLevel < minSoundLevel) {
            return;
        }
        currentSoundLevel = newCurrentSoundLevel;
    }
}