package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolateMergeToUpdate extends ActionVisitorTemplateMerge<StolateInfo, StolateInfo> {
	
	public VisiStolateMergeToUpdate(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolateInfo>> getActionClassHook() {
		return StdStolateDaoSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
