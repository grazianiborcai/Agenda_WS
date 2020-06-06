package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwotarchInfo, EmpwotarchInfo> {
	
	public VisiEmpwotarchMergeToSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmpwotarchInfo>> getActionClassHook() {
		return StdEmpwotarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotarchInfo> mergeHook(List<EmpwotarchInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
