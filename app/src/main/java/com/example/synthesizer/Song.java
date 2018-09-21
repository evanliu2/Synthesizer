package com.example.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private Note[] notes;
    public Song()
    {



    }

    public Song(Note[] notes)
    {

        this.notes = notes;

    }

//    public void add(Note note)
//    {
//
//        notes.add(note);
//
//    }

//    public void add(Chord chord)
//    {
//
//        for(Note note: chord.getChord())
//        {
//
//            notes.add(note);
//
//        }
//
//    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }
}
