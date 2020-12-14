package br.com.mind5.stats.userStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStore.info.StusoreInfo;
import br.com.mind5.stats.userStore.info.StusoreMerger;
import br.com.mind5.stats.userStoreLive.info.StusoreveInfo;
import br.com.mind5.stats.userStoreLive.model.decisionTree.RootStusoreveSelect;

final class VisiStusoreMergeStusoreve extends ActionVisitorTemplateMerge<StusoreInfo, StusoreveInfo> {
	
	public VisiStusoreMergeStusoreve(DeciTreeOption<StusoreInfo> option) {
		super(option, StusoreveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoreveInfo>> getTreeClassHook() {
		return RootStusoreveSelect.class;
	}
	
	
	
	@Override protected List<StusoreInfo> mergeHook(List<StusoreInfo> baseInfos, List<StusoreveInfo> selectedInfos) {	
		return StusoreMerger.mergeWithStusoreve(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
