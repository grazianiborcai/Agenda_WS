package br.com.mind5.business.employeeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpworgVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpworgInfo, EmpworgInfo> {
	
	public EmpworgVisiMergeToSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option, EmpworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpworgInfo>> getVisitorClassHook() {
		return EmpworgVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpworgInfo> mergeHook(List<EmpworgInfo> baseInfos, List<EmpworgInfo> selectedInfos) {	
		return EmpworgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
