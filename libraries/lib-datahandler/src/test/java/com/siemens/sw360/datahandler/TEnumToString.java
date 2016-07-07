/*
 * Copyright Siemens AG, 2013-2015. Part of the SW360 Portal Project.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.siemens.sw360.datahandler;

import com.siemens.sw360.datahandler.common.ThriftEnumUtils;
import com.tngtech.jgiven.annotation.Format;
import com.tngtech.jgiven.format.ArgumentFormatter;
import org.apache.thrift.TEnum;

import java.lang.annotation.*;
/**
 * @author daniele.fognini@tngtech.com
 */
@Documented
@Format(value = TEnumToString.EnumFormatter.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface TEnumToString {

    class EnumFormatter implements ArgumentFormatter<TEnum> {

        @Override
        public String format(TEnum o, String... args) {
            return "\"" + ThriftEnumUtils.enumToString(o) + "\"";
        }
    }
}
