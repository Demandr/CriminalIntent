package com.example.oleksandr.criminalintent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.File;
import java.util.UUID;

/**
 * Created by Oleksandr on 21.01.2017.
 */

public class CrimePhotoShowDialogFragment extends DialogFragment {
    private static final String ARG_CRIME_ID = "crime_id";

    private ImageView mPhotoView;
    private Crime mCrime;
    private UUID crimeId;
    private File mPhotoFile;

    public CrimePhotoShowDialogFragment(){}

    public static CrimePhotoShowDialogFragment newInstance (UUID crimeid){
        CrimePhotoShowDialogFragment dialogFragment = new CrimePhotoShowDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeid);
        dialogFragment.setArguments(args);
        dialogFragment.setStyle(STYLE_NO_TITLE, 0);
        return  dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
        mPhotoFile = CrimeLab.get(getActivity()).getPhotoFile(mCrime);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_crime_photo, container, false);
        mPhotoView = (ImageView) v.findViewById(R.id.large_crime_photo);
        updatePhotoView();

        return v;
    }

    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Point size = new Point();
            getActivity().getWindowManager().getDefaultDisplay()
                    .getSize(size);
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), size.x - 10, size.y);
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPhotoView != null) {
            mPhotoView.setImageDrawable(null);
        }
    }
}
