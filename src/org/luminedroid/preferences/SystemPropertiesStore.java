//
// SPDX-FileCopyrightText: 2022 Project Kaleidoscope
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.os.SystemProperties;
import android.preference.PreferenceDataStore;

public class SystemPropertiesStore extends androidx.preference.PreferenceDataStore
        implements PreferenceDataStore {

    public SystemPropertiesStore() {
    }

    public boolean getBoolean(String key, boolean defValue) {
        return SystemProperties.getBoolean(key, defValue);
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
        putString(key, value ? "1" : "0");
    }

    public void putInt(String key, int value) {
        putString(key, Integer.toString(value));
    }

    public void putLong(String key, long value) {
        putString(key, Long.toString(value));
    }

    public void putString(String key, String value) {
        SystemProperties.set(key, value);
    }

}
