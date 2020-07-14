package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.decisionTree.RootEmpnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpEmpnapInsert extends ActionVisitorTemplateActionV2<EmpInfo, EmpnapInfo> {	
	
	public VisiEmpEmpnapInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpnapInfo>> getTreeClassHook() {
		return RootEmpnapInsert.class;
	}
	
	
	
	protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpnapInfo> results) {
		return EmpMerger.mergeWithEmpnap(baseInfos, results);
	}
}
