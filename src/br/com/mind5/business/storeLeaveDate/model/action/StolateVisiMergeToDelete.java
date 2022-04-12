package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.StolateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiMergeToDelete extends ActionVisitorTemplateMerge<StolateInfo, StolateInfo> {
	
	public StolateVisiMergeToDelete(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return StolateRootSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
