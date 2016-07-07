
/*
 * Copyright Siemens AG, 2013-2015. Part of the SW360 Portal Project.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.siemens.sw360.portal.tags;

import com.google.common.base.Strings;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.siemens.sw360.datahandler.common.CommonUtils;
import com.siemens.sw360.datahandler.thrift.ThriftClients;
import com.siemens.sw360.datahandler.thrift.components.ReleaseClearingStateSummary;
import com.siemens.sw360.datahandler.thrift.users.User;
import com.siemens.sw360.datahandler.thrift.users.UserService;
import com.siemens.sw360.portal.common.JsonHelpers;
import com.siemens.sw360.portal.common.ThriftJsonSerializer;
import com.siemens.sw360.portal.users.UserUtils;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.OutSupport;
import org.apache.thrift.TException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This wraps the ReleaseClearingStateSummary
 *
 * @author birgit.heydenreich@tngtech.com
 */

public class DisplayReleaseClearingStateSummary extends SimpleTagSupport {

    private ReleaseClearingStateSummary releaseClearingStateSummary;

    public void setReleaseClearingStateSummary(ReleaseClearingStateSummary releaseClearingStateSummary) {
        this.releaseClearingStateSummary = releaseClearingStateSummary;
    }

    public void doTag() throws JspException, IOException {
        String s = "<span title=\"new release, under clearing, under clearing by the project clearing team, report available, approved\">" +
                releaseClearingStateSummary.newRelease + " " +
                releaseClearingStateSummary.underClearing + " " +
                releaseClearingStateSummary.underClearingByProjectTeam + " " +
                releaseClearingStateSummary.reportAvailable + " " +
                releaseClearingStateSummary.approved +
                "</span>";
        getJspContext().getOut().print(s);

    }

}

