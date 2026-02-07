//
// SPDX-FileCopyrightText: 2020 Havoc-OS
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.TypedArrayUtils;

public class SwitchPreference extends androidx.preference.SwitchPreferenceCompat {

    public SwitchPreference(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public SwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs, androidx.preference.R.attr.switchPreferenceCompatStyle);
    }

    public SwitchPreference(Context context) {
        this(context, null);
    }

    @Override
    protected void performClick(View view) {
        super.performClick(view);
    }
}
