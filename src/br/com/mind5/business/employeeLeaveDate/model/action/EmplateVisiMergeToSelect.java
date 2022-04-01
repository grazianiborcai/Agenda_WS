package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiMergeToSelect extends ActionVisitorTemplateMerge<EmplateInfo, EmplateInfo> {
	
	public EmplateVisiMergeToSelect(DeciTreeOption<EmplateInfo> option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmplateInfo>> getVisitorClassHook() {
		return EmplateVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {	
		return EmplateMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
