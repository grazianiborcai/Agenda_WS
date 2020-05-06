package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.RootEmparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpMergeEmparch extends ActionVisitorTemplateMergeV2<EmpInfo, EmparchInfo> {
	
	public VisiEmpMergeEmparch(DeciTreeOption<EmpInfo> option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmparchInfo>> getTreeClassHook() {
		return RootEmparchSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return EmpMerger.mergeWithEmparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
