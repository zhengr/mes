/**
 * ********************************************************************
 * Code developed by amazing QCADOO developers team.
 * Copyright (c) Qcadoo Limited sp. z o.o. (2010)
 * ********************************************************************
 */

package com.qcadoo.mes.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcadoo.mes.api.TranslationService;
import com.qcadoo.mes.internal.MenuService;
import com.qcadoo.mes.internal.TranslationServiceImpl;
import com.qcadoo.mes.model.internal.DataDefinitionParser;
import com.qcadoo.mes.newview.ViewComponentsResolver;
import com.qcadoo.mes.view.internal.ViewDefinitionParser;

@Service
public final class Application {

    @Autowired
    private DataDefinitionParser dataDefinitionParser;

    @Autowired
    private ViewDefinitionParser viewDefinitionParser;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ViewComponentsResolver viewComponentResolver;

    @PostConstruct
    public void init() {
        System.out.println("XXX");
        viewComponentResolver.refreshAvaliebleComponentsList();
        dataDefinitionParser.parse();
        viewDefinitionParser.parse();
        ((TranslationServiceImpl) translationService).init();
        menuService.updateViewDefinitionDatabase();

    }

}
