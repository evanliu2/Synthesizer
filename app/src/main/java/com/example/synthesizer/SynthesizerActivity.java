package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.SystemClock;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonTechieFive;
    private Button buttonStar;
    private Button buttonFinale;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHighA;
    private int noteHighBb;
    private int noteHighB;
    private int noteHighC;
    private int noteHighCs;
    private int noteHighD;
    private int noteHighDs;
    private int noteHighE;
    private int noteHighF;
    private int noteHighFs;
    private int noteHighG;
    private int noteHighGs;
    private boolean chordYeet;
    private Map<Integer, Integer> noteMap;
    private Handler handler;
    public static final float DEFAULT_VOLUME = 1f;
    public static final float DEFAULT_RATE = 1f;
    public static final int DEFAULT_PRIORITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        handler = new Handler();
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();

    }

    private void initializeNoteMap() {

        noteMap = new HashMap<>();
        // in a map you store a key:value pair
        // the key is the button Id, the value is the noteId
        noteMap.put(R.id.button_synth_A, noteA);
        noteMap.put(R.id.button_synth_Bb, noteBb);
        noteMap.put(R.id.button_synth_B, noteB);
        noteMap.put(R.id.button_synth_C, noteC);
        noteMap.put(R.id.button_synth_Cs, noteCs);
        noteMap.put(R.id.button_synth_D, noteD);
        noteMap.put(R.id.button_synth_Ds, noteDs);
        noteMap.put(R.id.button_synth_E, noteE);
        noteMap.put(R.id.button_synth_F, noteF);
        noteMap.put(R.id.button_synth_Fs, noteFs);
        noteMap.put(R.id.button_synth_G, noteG);
        noteMap.put(R.id.button_synth_Gs, noteGs);


    }

    private void wireWidgets() {

        buttonA = findViewById(R.id.button_synth_A);
        buttonBb = findViewById(R.id.button_synth_Bb);
        buttonB = findViewById(R.id.button_synth_B);
        buttonC = findViewById(R.id.button_synth_C);
        buttonCs = findViewById(R.id.button_synth_Cs);
        buttonD = findViewById(R.id.button_synth_D);
        buttonDs = findViewById(R.id.button_synth_Ds);
        buttonE = findViewById(R.id.button_synth_E);
        buttonF = findViewById(R.id.button_synth_F);
        buttonFs = findViewById(R.id.button_synth_Fs);
        buttonG = findViewById(R.id.button_synth_G);
        buttonGs = findViewById(R.id.button_synth_Gs);
        buttonTechieFive = findViewById(R.id.button_synth_black_swan);
        buttonStar = findViewById(R.id.button_synth_star);
        buttonFinale = findViewById(R.id.button_synth_finale);

    }

    private void setListeners() {

        buttonA.setOnClickListener(this);
        buttonBb.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonCs.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonDs.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonFs.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonGs.setOnClickListener(this);
        buttonTechieFive.setOnClickListener(this);
        buttonStar.setOnClickListener(this);
        buttonFinale.setOnClickListener(this);

    }

    private void initializeSoundPool() {

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        noteA = soundPool.load(this, R.raw.scalea,1);
        noteBb = soundPool.load(this, R.raw.scalebb,1);
        noteB = soundPool.load(this, R.raw.scaleb,1);
        noteC = soundPool.load(this, R.raw.scalec,1);
        noteCs = soundPool.load(this, R.raw.scalecs,1);
        noteD = soundPool.load(this, R.raw.scaled,1);
        noteDs = soundPool.load(this, R.raw.scaleds,1);
        noteE = soundPool.load(this, R.raw.scalee,1);
        noteF = soundPool.load(this, R.raw.scalef,1);
        noteFs = soundPool.load(this, R.raw.scalefs,1);
        noteG = soundPool.load(this, R.raw.scaleg,1);
        noteGs = soundPool.load(this, R.raw.scalegs,1);
        noteHighA = soundPool.load(this, R.raw.scalehigha,1);
        noteHighBb = soundPool.load(this, R.raw.scalehighbb,1);
        noteHighB = soundPool.load(this, R.raw.scalehighb,1);
        noteHighC = soundPool.load(this, R.raw.scalehighc,1);
        noteHighCs = soundPool.load(this, R.raw.scalehighcs,1);
        noteHighD = soundPool.load(this, R.raw.scalehighd,1);
        noteHighDs = soundPool.load(this, R.raw.scalehighds,1);
        noteHighE = soundPool.load(this, R.raw.scalehighe,1);
        noteHighF = soundPool.load(this, R.raw.scalehighf,1);
        noteHighFs = soundPool.load(this, R.raw.scalehighfs,1);
        noteHighG = soundPool.load(this, R.raw.scalehighg,1);
        noteHighGs = soundPool.load(this, R.raw.scalehighgs,1);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.button_synth_A:
                soundPool.play(noteA,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_Bb:
                soundPool.play(noteBb,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_B:
                soundPool.play(noteB,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_C:
                soundPool.play(noteC,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_Cs:
                soundPool.play(noteCs,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_D:
                soundPool.play(noteD,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_Ds:
                soundPool.play(noteDs,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_E:
                soundPool.play(noteE,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_F:
                soundPool.play(noteF,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_Fs:
                soundPool.play(noteFs,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_G:
                soundPool.play(noteG,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_Gs:
                soundPool.play(noteGs,1.0f,1.0f,1,0,1f);
                break;
            case R.id.button_synth_black_swan:
                Accompany(0, getBlackSwan(), getBlackSwanAccompanyment());
                break;
            case R.id.button_synth_star:
                Accompany(0, getTwinkleTwinkle());
            case R.id.button_synth_finale:
                Accompany(0, Finale(), FinaleAccompanyment1(), FinaleAccompanyment2());
        }

    }

    private Note[] Finale() {

        Note[] f =

                {(new Note(noteGs, 300)),
                 (new Note(noteGs, 175)),
                 (new Note(noteHighBb, 175)),
                 (new Note(noteHighC, 275)),
                 (new Note(noteGs, 300)),
                 (new Note(noteHighBb, 300)),
                 (new Note(noteHighBb, 175)),
                 (new Note(noteHighC, 175)),
                 (new Note(noteG, 300)),
                 (new Note(noteDs, 300)),

                 (new Note(noteGs, 300)),
                 (new Note(noteGs, 175)),
                 (new Note(noteHighBb, 175)),
                 (new Note(noteHighC, 300)),
                 (new Note(noteHighGs, 300)),
                 (new Note(noteHighG, 300)),
                 (new Note(noteHighDs, 300)),
                 (new Note(noteHighBb, 300)),
                 (new Note(noteG, 300)),

                 (new Note(noteGs, 300)),
                 (new Note(noteGs, 175)),
                 (new Note(noteHighBb, 175)),
                 (new Note(noteHighC, 300)),
                 (new Note(noteGs, 300)),
                 (new Note(noteHighBb, 300)),
                 (new Note(noteHighBb, 175)),
                 (new Note(noteHighC, 175)),
                 (new Note(noteG, 300)),
                 (new Note(noteDs, 300)),

                 (new Note(noteHighA, 300)),
                 (new Note(noteHighA, 175)),
                 (new Note(noteHighBb, 200)),
                 (new Note(noteHighC, 300)),
                 (new Note(noteHighF, 300)),
                 (new Note(noteHighE, 300)),
                 (new Note(noteHighG, 300)),
                 (new Note(noteHighF, 750)),

                        (new Note(noteGs, 300)),
                        (new Note(noteGs, 175)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 275)),
                        (new Note(noteGs, 300)),
                        (new Note(noteHighBb, 300)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 175)),
                        (new Note(noteG, 300)),
                        (new Note(noteDs, 300)),

                        (new Note(noteGs, 300)),
                        (new Note(noteGs, 175)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 300)),
                        (new Note(noteHighGs, 300)),
                        (new Note(noteHighG, 300)),
                        (new Note(noteHighDs, 300)),
                        (new Note(noteHighBb, 300)),
                        (new Note(noteG, 300)),

                        (new Note(noteGs, 300)),
                        (new Note(noteGs, 175)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 300)),
                        (new Note(noteGs, 300)),
                        (new Note(noteHighBb, 300)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 175)),
                        (new Note(noteG, 300)),
                        (new Note(noteDs, 300)),

                        (new Note(noteHighA, 300)),
                        (new Note(noteHighA, 175)),
                        (new Note(noteHighBb, 200)),
                        (new Note(noteHighC, 300)),
                        (new Note(noteHighF, 300)),
                        (new Note(noteHighD, 600)),
                        (new Note(noteHighC, 150)),
                        (new Note(noteHighC, 150)),
                        (new Note(noteHighC, 150)),
                        (new Note(noteHighC, 150)),

                        //Finale

                        (new Note(noteGs, 300)),
                        (new Note(noteGs, 175)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 275)),
                        (new Note(noteGs, 300)),
                        (new Note(noteHighBb, 300)),
                        (new Note(noteHighBb, 175)),
                        (new Note(noteHighC, 175)),
                        (new Note(noteG, 300)),
                        (new Note(noteDs, 300)),

                        (new Note(noteGs, 300)),

                };



        return f;

    }

    private Note[] FinaleAccompanyment1() {

        Note[] fa1 =

                {new Note(noteHighBb, 2475),
                 new Note(noteHighC, 2450),
                 new Note(noteHighCs, 2475),
                 new Note(noteHighD, 2625),

                        new Note(noteHighBb, 2475),
                        new Note(noteHighC, 2450),
                        new Note(noteHighCs, 2475),
                        new Note(noteHighA, 2475),

                        new Note(noteHighC, 1875),
                        new Note(noteHighC, 600),
                        new Note(noteHighC, 1875),
                };



        return fa1;

    }

    private Note[] FinaleAccompanyment2() {

        Note[] fa2 = {new Note(noteHighF, 2475),
                      new Note(noteHighGs, 1250),
                      new Note(noteHighG, 1200),
                      new Note(noteHighGs, 2475),
                      new Note(noteHighA, 2625),

                            new Note(noteHighF, 2475),
                            new Note(noteHighGs, 1250),
                            new Note(noteHighG, 1200),
                            new Note(noteHighGs, 4950),

                            new Note(noteHighF, 1875),
                            new Note(noteHighDs, 600),
                            new Note(noteHighDs, 1875),

                     };
        return fa2;

    }



    private Note[] getTwinkleTwinkle() {

        Note[] tt =

                        {(new Note(noteHighA, 500)),
                        (new Note(noteHighA, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighFs, 500)),
                        (new Note(noteHighFs, 500)),
                        (new Note(noteHighE, 1000)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighB, 500)),
                        (new Note(noteHighB, 500)),
                        (new Note(noteHighA, 1000)),

                        (new Note(noteHighE, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighB, 1000)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighB, 1000)),

                        (new Note(noteHighA, 500)),
                        (new Note(noteHighA, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighE, 500)),
                        (new Note(noteHighFs, 500)),
                        (new Note(noteHighFs, 500)),
                        (new Note(noteHighE, 1000)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighD, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighCs, 500)),
                        (new Note(noteHighB, 500)),
                        (new Note(noteHighB, 500)),
                        (new Note(noteHighA, 1000)),};

        return tt;

    }

    private Note[] getBlackSwan()
    {

        Note[] bs =

                {(new Note(noteHighA, 1100)),
                (new Note(noteD,400)),
                (new Note(noteE,400)),
                (new Note(noteF,400)),
                (new Note(noteG,400)),
                (new Note(noteHighA,1100)),
                (new Note(noteF,400)),
                (new Note(noteA,1100)),
                (new Note(noteF,400)),
                (new Note(noteHighA,1100)),
                (new Note(noteD,400)),
                (new Note(noteF,400)),
                (new Note(noteD,400)),
                (new Note(noteBb,400)),
                (new Note(noteF,400)),
                (new Note(noteD,400))};

        return bs;

    }

    private Note[] getBlackSwanAccompanyment()
    {

        Note[] bsa =

                {(new Note(noteA,2700)),
                (new Note(noteA,1500)),
                (new Note(noteA,1500)),
                (new Note(noteA,1500)),
                (new Note(noteHighF,800)),
                (new Note(noteHighBb,800)),
                (new Note(noteHighD,400))};

         return bsa;

    }

    private void playNote(int note, int loops) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY,0, DEFAULT_RATE);
    }
    private void playNote(int note) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY,0, DEFAULT_RATE);
    }
    private void playNote(Note note) {
        playNote(note.getNoteId(),0);
    }

    private void Accompany(long startDelay, Note[]... songs) {
        long base = SystemClock.uptimeMillis() + startDelay;
        for (Note[] song: songs) {
            long delay = 0;
            for (final Note note: song) {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        soundPool.play(note.getNoteId(), 1f, 1f, 1, 0, 1f);
                    }
                }, base + delay);
                delay+=note.getDelay();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
}