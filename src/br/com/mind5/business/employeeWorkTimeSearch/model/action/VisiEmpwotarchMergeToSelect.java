package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotarchMergeToSelect extends ActionVisitorTemplateMerge<EmpwotarchInfo, EmpwotarchInfo> {
	
	public VisiEmpwotarchMergeToSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwotarchInfo>> getActionClassHook() {
		return StdEmpwotarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotarchInfo> mergeHook(List<EmpwotarchInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
