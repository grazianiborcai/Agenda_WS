package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateDeleteByEmpos;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposEmplevateDelete extends ActionVisitorTemplateAction<EmposInfo, EmplateInfo> {
	
	public VisiEmposEmplevateDelete(DeciTreeOption<EmposInfo> option) {
		super(option, EmposInfo.class, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return RootEmplateDeleteByEmpos.class;
	}
}
