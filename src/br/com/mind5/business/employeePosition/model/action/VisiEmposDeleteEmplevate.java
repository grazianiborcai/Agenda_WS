package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateDeleteByEmpos;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmplevate extends ActionVisitorTemplateActionV2<EmposInfo, EmplateInfo> {
	
	public VisiEmposDeleteEmplevate(DeciTreeOption<EmposInfo> option) {
		super(option, EmposInfo.class, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return RootEmplateDeleteByEmpos.class;
	}
}
