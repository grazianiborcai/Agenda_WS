package br.com.mind5.business.storeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmapVisiMergeStolis extends ActionVisitorTemplateMerge<StowotmapInfo, StolisInfo> {
	
	public StowotmapVisiMergeStolis(DeciTreeOption<StowotmapInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}
	
	
	
	@Override protected List<StowotmapInfo> mergeHook(List<StowotmapInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return StowotmapMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
