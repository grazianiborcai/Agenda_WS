package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateMergeToDelete extends ActionVisitorTemplateMergeV2<EmplateInfo, EmplateInfo> {
	
	public VisiEmplateMergeToDelete(DeciTreeOption<EmplateInfo> option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmplateInfo>> getActionClassHook() {
		return StdEmplateDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {	
		return EmplateMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
