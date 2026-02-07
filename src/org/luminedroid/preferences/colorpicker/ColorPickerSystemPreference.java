//
// SPDX-FileCopyrightText: 2011 Sergey Margaritov
// SPDX-FileCopyrightText: 2013 Slimroms
// SPDX-FileCopyrightText: 2015 The TeamEos Project
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences.colorpicker;

import android.content.Context;
import android.util.AttributeSet;

import org.luminedroid.preferences.SystemSettingsStore;

public class ColorPickerSystemPreference extends ColorPickerPreference {

    public ColorPickerSystemPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPreferenceDataStore(new SystemSettingsStore(context.getContentResolver()));
    }

    public ColorPickerSystemPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPreferenceDataStore(new SystemSettingsStore(context.getContentResolver()));
    }

    public ColorPickerSystemPreference(Context context) {
        super(context, null);
        setPreferenceDataStore(new SystemSettingsStore(context.getContentResolver()));
    }
}
