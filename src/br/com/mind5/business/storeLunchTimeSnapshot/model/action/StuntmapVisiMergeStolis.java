package br.com.mind5.business.storeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmapVisiMergeStolis extends ActionVisitorTemplateMerge<StuntmapInfo, StolisInfo> {
	
	public StuntmapVisiMergeStolis(DeciTreeOption<StuntmapInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmapInfo> mergeHook(List<StuntmapInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return StuntmapMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
