package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.decisionTree.EmpnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiEmpnapInsert extends ActionVisitorTemplateAction<EmpInfo, EmpnapInfo> {	
	
	public EmpVisiEmpnapInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpnapInfo>> getTreeClassHook() {
		return EmpnapRootInsert.class;
	}
	
	
	
	protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpnapInfo> results) {
		return EmpMerger.mergeWithEmpnap(baseInfos, results);
	}
}
