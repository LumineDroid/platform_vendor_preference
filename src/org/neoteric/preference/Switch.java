/*
 * Copyright (C) 2022 The Nameless-AOSP Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.neoteric.preference;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;

public class Switch extends android.widget.Switch {

    private static final VibrationEffect EFFECT_CLICK =
            VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK);

    private final Vibrator mVibrator;

    public Switch(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mVibrator = context.getSystemService(Vibrator.class);
    }

    public Switch(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Switch(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.switchStyle);
    }

    public Switch(Context context) {
        this(context, null);
    }

    @Override
    public void toggle() {
        super.toggle();
        mVibrator.vibrate(EFFECT_CLICK);
    }
}
