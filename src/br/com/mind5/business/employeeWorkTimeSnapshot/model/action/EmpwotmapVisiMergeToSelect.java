package br.com.mind5.business.employeeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmapVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpwotmapInfo, EmpwotmapInfo> {
	
	public EmpwotmapVisiMergeToSelect(DeciTreeOption<EmpwotmapInfo> option) {
		super(option, EmpwotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpwotmapInfo>> getVisitorClassHook() {
		return EmpwotmapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmapInfo> mergeHook(List<EmpwotmapInfo> baseInfos, List<EmpwotmapInfo> selectedInfos) {	
		return EmpwotmapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
