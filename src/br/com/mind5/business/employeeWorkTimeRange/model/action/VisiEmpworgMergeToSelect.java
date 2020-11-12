package br.com.mind5.business.employeeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpworgMergeToSelect extends ActionVisitorTemplateMergeV2<EmpworgInfo, EmpworgInfo> {
	
	public VisiEmpworgMergeToSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option, EmpworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmpworgInfo>> getActionClassHook() {
		return StdEmpworgDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpworgInfo> mergeHook(List<EmpworgInfo> baseInfos, List<EmpworgInfo> selectedInfos) {	
		return EmpworgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
