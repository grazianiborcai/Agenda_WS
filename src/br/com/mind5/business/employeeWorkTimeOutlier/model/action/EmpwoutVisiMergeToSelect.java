package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwoutVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpwoutInfo, EmpwoutInfo> {
	
	public EmpwoutVisiMergeToSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpwoutInfo>> getVisitorClassHook() {
		return EmpwoutVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwoutMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
