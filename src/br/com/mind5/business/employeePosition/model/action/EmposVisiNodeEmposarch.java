package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.EmposNodeEmposarch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposVisiNodeEmposarch extends ActionVisitorTemplateAction<EmposInfo, EmposInfo> {

	public EmposVisiNodeEmposarch(DeciTreeOption<EmposInfo> option) {
		super(option, EmposInfo.class, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposInfo>> getTreeClassHook() {
		return EmposNodeEmposarch.class;
	}
	
	
	
	@Override protected List<EmposInfo> toBaseClassHook(List<EmposInfo> baseInfos, List<EmposInfo> results) {
		return results;
	}
}
