package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.EmplateRootDeleteFromEmpos;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposVisiEmplevateDelete extends ActionVisitorTemplateAction<EmposInfo, EmplateInfo> {
	
	public EmposVisiEmplevateDelete(DeciTreeOption<EmposInfo> option) {
		super(option, EmposInfo.class, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return EmplateRootDeleteFromEmpos.class;
	}
}
