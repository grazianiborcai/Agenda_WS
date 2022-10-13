package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.decisionTree.PeregNodePersonUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiNodePersonUpdate extends ActionVisitorTemplateAction<PeregInfo, PeregInfo> {

	public PeregVisiNodePersonUpdate(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class, PeregInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeregInfo>> getTreeClassHook() {
		return PeregNodePersonUpdate.class;
	}
	
	
	
	@Override protected List<PeregInfo> toBaseClassHook(List<PeregInfo> baseInfos, List<PeregInfo> results) {
		return results;
	}
}
