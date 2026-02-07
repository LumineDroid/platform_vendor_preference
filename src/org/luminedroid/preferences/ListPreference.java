//
// SPDX-FileCopyrightText: 2019-2022 Evolution-X
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

public class ListPreference extends androidx.preference.ListPreference {
    private boolean mAutoSummary = false;

    public ListPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListPreference(Context context) {
        super(context);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        if (mAutoSummary || TextUtils.isEmpty(getSummary())) {
            setSummary(getEntry(), true);
        }
    }

    @Override
    public void setSummary(CharSequence summary) {
        setSummary(summary, false);
    }

    private void setSummary(CharSequence summary, boolean autoSummary) {
        mAutoSummary = autoSummary;
        super.setSummary(summary);
    }
}
