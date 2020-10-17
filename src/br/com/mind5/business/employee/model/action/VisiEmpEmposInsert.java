package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposInsertProfessional;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpEmposInsert extends ActionVisitorTemplateActionV2<EmpInfo, EmposInfo> {
	
	public VisiEmpEmposInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposInfo>> getTreeClassHook() {
		return RootEmposInsertProfessional.class;
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmposInfo> results) {
		return baseInfos;
	}
}
