package com.example.synthesizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Chord {

    private int delay;

    private Note[] chord;

    public Chord(Note[] inputChord, int delay) {
        this.chord = chord;
        this.delay = delay;
        chord = new Note[inputChord.length];
        for(int i = 0; i < inputChord.length; i++)
        {

            chord[i] = inputChord[i];

        }

    }

    public Note[] getChord() {
        return chord;
    }

    public void setChord(Note[] chord) {
        this.chord = chord;
    }

    @Override
    public String toString() {
        return "Chord{" +
                "chord=" + chord +
                '}';
    }
}
