package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.decisionTree.RootStolarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiMergeStolarch extends ActionVisitorTemplateMerge<StolateInfo, StolarchInfo> {
	
	public StolateVisiMergeStolarch(DeciTreeOption<StolateInfo> option) {
		super(option, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolarchInfo>> getTreeClassHook() {
		return RootStolarchSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> baseInfos, List<StolarchInfo> selectedInfos) {	
		return StolateMerger.mergeWithStolarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
