package br.com.mind5.stats.statsUserStore.userStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreInfo;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreMerger;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreAggr.model.decisionTree.StusoraggRootSelect;

public final class StusoreVisiMergeStusoragg extends ActionVisitorTemplateMerge<StusoreInfo, StusoraggInfo> {
	
	public StusoreVisiMergeStusoragg(DeciTreeOption<StusoreInfo> option) {
		super(option, StusoraggInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoraggInfo>> getTreeClassHook() {
		return StusoraggRootSelect.class;
	}
	
	
	
	@Override protected List<StusoreInfo> mergeHook(List<StusoreInfo> baseInfos, List<StusoraggInfo> selectedInfos) {	
		return StusoreMerger.mergeWithStusoragg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
