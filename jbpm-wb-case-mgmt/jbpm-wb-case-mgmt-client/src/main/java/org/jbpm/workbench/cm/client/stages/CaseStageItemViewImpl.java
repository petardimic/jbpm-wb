/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.workbench.cm.client.stages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.user.client.TakesValue;
import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.ListItem;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.workbench.cm.client.util.AbstractView;
import org.jbpm.workbench.cm.model.CaseStageSummary;

import static org.jboss.errai.common.client.dom.DOMUtil.addCSSClass;

@Dependent
@Templated
public class CaseStageItemViewImpl extends AbstractView<CaseStagesPresenter> implements TakesValue<CaseStageSummary>,
                                                                                        IsElement {

    @Inject
    @DataField("stage-name")
    @Bound
    private Span name;

    @Inject
    @DataField("list-group-item")
    private ListItem listGroupItem;

    @Inject
    @AutoBound
    private DataBinder<CaseStageSummary> caseStageSummary;

    @PostConstruct
    public void init() {
        tooltip(name);
    }

    @Override
    public HTMLElement getElement() {
        return listGroupItem;
    }

    @Override
    public CaseStageSummary getValue() {
        return caseStageSummary.getModel();
    }

    @Override
    public void setValue(final CaseStageSummary model) {
        this.caseStageSummary.setModel(model);
    }

    void showStageActive() {
        addCSSClass(this.listGroupItem,
                    "active");
    }
}