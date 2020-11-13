package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateMergeToDelete extends ActionVisitorTemplateMerge<EmplateInfo, EmplateInfo> {
	
	public VisiEmplateMergeToDelete(DeciTreeOption<EmplateInfo> option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplateInfo>> getActionClassHook() {
		return StdEmplateDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {	
		return EmplateMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
