//
// SPDX-FileCopyrightText: 2019-2020 The Spark Project
// SPDX-License-Identifier: Apache-2.0
//

package org.luminedroid.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class SystemSettingIntListPreference extends SystemSettingListPreference {

    public SystemSettingIntListPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SystemSettingIntListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SystemSettingIntListPreference(Context context) {
        super(context);
    }

    @Override
    protected boolean persistString(String value) {
        return persistInt(Integer.parseInt(value));
    }

    @Override
    protected String getPersistedString(String defaultReturnValue) {
        return String.valueOf(getPersistedInt(Integer.parseInt(defaultReturnValue)));
    }

}
