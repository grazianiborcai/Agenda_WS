package br.com.mind5.stats.userStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStore.info.StusoreInfo;
import br.com.mind5.stats.userStore.info.StusoreMerger;
import br.com.mind5.stats.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.userStoreAggr.model.decisionTree.RootStusoraggSelect;

final class VisiStusoreMergeStusoragg extends ActionVisitorTemplateMerge<StusoreInfo, StusoraggInfo> {
	
	public VisiStusoreMergeStusoragg(DeciTreeOption<StusoreInfo> option) {
		super(option, StusoraggInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoraggInfo>> getTreeClassHook() {
		return RootStusoraggSelect.class;
	}
	
	
	
	@Override protected List<StusoreInfo> mergeHook(List<StusoreInfo> baseInfos, List<StusoraggInfo> selectedInfos) {	
		return StusoreMerger.mergeWithStusoragg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
