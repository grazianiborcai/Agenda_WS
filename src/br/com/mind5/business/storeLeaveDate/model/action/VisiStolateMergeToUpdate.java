package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolateMergeToUpdate extends ActionVisitorTemplateMergeV2<StolateInfo, StolateInfo> {
	
	public VisiStolateMergeToUpdate(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StolateInfo>> getActionClassHook() {
		return StdStolateDaoSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
