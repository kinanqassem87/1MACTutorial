package com.example.android.miwok_starter_code;

public class Word {
      private String mMiwokTranslation;
      private String mDefaultTranslation;
      private  int mImageResourceId = NO_IMAGE_PROVEDED;
      private static final int NO_IMAGE_PROVEDED = -1;
      private int mAudioResourceId;


    public Word(String DefaultTranslation, String MiwokTranslation,int AudioResourceId)
    {

        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceId = AudioResourceId;
    }

    public Word(String DefaultTranslation, String MiwokTranslation,int ImageResourceId,int AudioResourceId)
    {

        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }

    public String getmMiwokTranslation(){return mMiwokTranslation;}

    public String getmDefaultTranslation(){return mDefaultTranslation;}

    public int getImageResourceId(){return mImageResourceId;}

    public int getAudioResourceId(){return mAudioResourceId;}


    //when put image, imageResourceId will be change
    // to 0 visible  4 unvisible  8 gone

    public Boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVEDED;
    }
}
