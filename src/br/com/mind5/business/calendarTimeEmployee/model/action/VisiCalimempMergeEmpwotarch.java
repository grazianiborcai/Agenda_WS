package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempMerger;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.RootEmpwotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalimempMergeEmpwotarch extends ActionVisitorTemplateMerge<CalimempInfo, EmpwotarchInfo> {
	
	public VisiCalimempMergeEmpwotarch(DeciTreeOption<CalimempInfo> option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotarchInfo>> getTreeClassHook() {
		return RootEmpwotarchSelect.class;
	}
	
	
	
	@Override protected List<CalimempInfo> mergeHook(List<CalimempInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {	
		return CalimempMerger.mergeWithEmpwotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
