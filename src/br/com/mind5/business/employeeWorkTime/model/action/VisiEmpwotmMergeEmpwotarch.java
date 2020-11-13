package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.RootEmpwotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmMergeEmpwotarch extends ActionVisitorTemplateMerge<EmpwotmInfo, EmpwotarchInfo> {
	
	public VisiEmpwotmMergeEmpwotarch(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotarchInfo>> getTreeClassHook() {
		return RootEmpwotarchSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
