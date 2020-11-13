package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwoutMergeToSelect extends ActionVisitorTemplateMerge<EmpwoutInfo, EmpwoutInfo> {
	
	public VisiEmpwoutMergeToSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwoutInfo>> getActionClassHook() {
		return StdEmpwoutDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwoutMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
