//
// SPDX-FileCopyrightText: 2019-2022 Evolution X
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.os.SystemProperties;
import android.preference.PreferenceDataStore;

public class SystemPropStore extends androidx.preference.PreferenceDataStore
        implements PreferenceDataStore {

    public boolean getBoolean(String key, boolean defValue) {
        return SystemProperties.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return Float.parseFloat(SystemProperties.get(key, "" + defValue));
    }

    public int getInt(String key, int defValue) {
        return SystemProperties.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return SystemProperties.getLong(key, defValue);
    }

    public String getString(String key, String defValue) {
        return SystemProperties.get(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        SystemProperties.set(key, "" + value);
    }

    public void putFloat(String key, float value) {
        SystemProperties.set(key, "" + value);
    }

    public void putInt(String key, int value) {
        SystemProperties.set(key, "" + value);
    }

    public void putLong(String key, long value) {
        SystemProperties.set(key, "" + value);
    }

    public void putString(String key, String value) {
        SystemProperties.set(key, value);
    }

}
