//
// SPDX-FileCopyrightText: 2019-2022 Evolution X
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

public class SystemPropListPreference extends ListPreference {

    public SystemPropListPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPreferenceDataStore(new SystemPropStore());
    }

    public SystemPropListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPreferenceDataStore(new SystemPropStore());
    }

    public SystemPropListPreference(Context context) {
        super(context);
        setPreferenceDataStore(new SystemPropStore());
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        // This is what default ListPreference implementation is doing without respecting
        // real default value:
        //setValue(restoreValue ? getPersistedString(mValue) : (String) defaultValue);
        // Instead, we better do
        setValue(restoreValue ? getPersistedString((String) defaultValue) : (String) defaultValue);
    }

}
