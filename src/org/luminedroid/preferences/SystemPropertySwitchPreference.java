//
// SPDX-FileCopyrightText: 2014 The CyanogenMod Project
// SPDX-FileCopyrightText: 2017 AICP
// SPDX-FileCopyrightText: 2022 Project Kaleidoscope
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.content.Context;
import android.util.AttributeSet;

import androidx.preference.SwitchPreference;

public class SystemPropertySwitchPreference extends SwitchPreference {

    public SystemPropertySwitchPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPreferenceDataStore(new SystemPropertiesStore());
    }

    public SystemPropertySwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPreferenceDataStore(new SystemPropertiesStore());
    }

    public SystemPropertySwitchPreference(Context context) {
        super(context);
        setPreferenceDataStore(new SystemPropertiesStore());
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        if (defaultValue != null) {
            setChecked(restoreValue ? getPersistedBoolean((Boolean) defaultValue)
                    : (Boolean) defaultValue);
        } else {
            // Handle the case where defaultValue is null
            // You can set a default boolean value here or handle it according to your application's logic
            setChecked(false); // For example, setting it to false as default
        }
    }
}
