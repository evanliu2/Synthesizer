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

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }
}
