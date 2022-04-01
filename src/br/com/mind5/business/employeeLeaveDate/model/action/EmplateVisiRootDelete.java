package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.EmplateRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiRootDelete extends ActionVisitorTemplateAction<EmplateInfo, EmplateInfo> {

	public EmplateVisiRootDelete(DeciTreeOption<EmplateInfo> option) {
		super(option, EmplateInfo.class, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return EmplateRootDelete.class;
	}
	
	
	
	@Override protected List<EmplateInfo> toBaseClassHook(List<EmplateInfo> baseInfos, List<EmplateInfo> results) {
		return results;
	}
}
