//
// SPDX-FileCopyrightText: 2010 Daniel Nilsson
// SPDX-FileCopyrightText: 2013 Slimroms
// SPDX-FileCopyrightText: 2020 Havoc-OS
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences.colorpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import org.luminedroid.preferences.R;

public class ColorPickerDialog extends AlertDialog implements ColorPickerView.OnColorChangedListener, View.OnClickListener, View.OnKeyListener {

    private ColorPickerView mColorPicker;
    private ColorPickerPanelView mOldColor;
    private ColorPickerPanelView mNewColor;
    private EditText mHex;

    private OnColorChangedListener mListener;

    private final Context mContext;

    public interface OnColorChangedListener {
        void onColorChanged(int color);
    }

    ColorPickerDialog(Context context, int initialColor) {
        super(context);

        init(initialColor);

        mContext = context;
    }

    private void init(int color) {
        if (getWindow() != null) {
            getWindow().setFormat(PixelFormat.RGBA_8888);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setUp(color);
        }
    }

    private void setColorFromHex() {
        String text = mHex.getText().toString();
        try {
            int newColor = ColorPickerPreference.convertToColorInt(text);
            mColorPicker.setColor(newColor, true);
        } catch (Exception ignored) {
        }
    }

    private void setUp(int color) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        assert inflater != null;
        View layout = inflater.inflate(R.layout.preference_color_picker, null);

        mColorPicker = layout.findViewById(R.id.color_picker_view);
        mOldColor = layout.findViewById(R.id.old_color_panel);
        mNewColor = layout.findViewById(R.id.new_color_panel);

        mHex = layout.findViewById(R.id.hex);

        ((LinearLayout) mOldColor.getParent()).setPadding(Math.round(mColorPicker.getDrawingOffset()),
                0, Math.round(mColorPicker.getDrawingOffset()), 0);

        mOldColor.setOnClickListener(this);
        mNewColor.setOnClickListener(this);
        mColorPicker.setOnColorChangedListener(this);
        mOldColor.setColor(color);
        mColorPicker.setColor(color, true);

        if (mHex != null) {
            mHex.setText(ColorPickerPreference.convertToRGB(color));
            mHex.setOnKeyListener(this);
        }

        setView(layout);
    }

    @Override
    public void onColorChanged(int color) {

        mNewColor.setColor(color);
        try {
            if (mHex != null) {
                mHex.setText(ColorPickerPreference.convertToRGB(color));
            }
        } catch (Exception ignored) {
        }
    }

    void setAlphaSliderVisible(boolean visible) {
        mColorPicker.setAlphaSliderVisible(visible);
    }

    /**
     * Set a OnColorChangedListener to get notified when the color selected by the user has changed.
     *
     * @param listener
     */
    void setOnColorChangedListener(OnColorChangedListener listener) {
        mListener = listener;
    }

    public int getColor() {
        return mColorPicker.getColor();
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
            setColorFromHex();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.new_color_panel) {
            if (mListener != null) {
                mListener.onColorChanged(mNewColor.getColor());
            }
        }
        dismiss();
    }

    @NonNull
    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt("old_color", mOldColor.getColor());
        state.putInt("new_color", mNewColor.getColor());
        dismiss();
        return state;
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mOldColor.setColor(savedInstanceState.getInt("old_color"));
        mColorPicker.setColor(savedInstanceState.getInt("new_color"), true);
    }
}
