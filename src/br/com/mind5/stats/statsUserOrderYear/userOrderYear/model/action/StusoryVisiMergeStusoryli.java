package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryMerger;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.decisionTree.StusoryliRootSelect;

public final class StusoryVisiMergeStusoryli extends ActionVisitorTemplateMerge<StusoryInfo, StusoryliInfo> {
	
	public StusoryVisiMergeStusoryli(DeciTreeOption<StusoryInfo> option) {
		super(option, StusoryliInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoryliInfo>> getTreeClassHook() {
		return StusoryliRootSelect.class;
	}
	
	
	
	@Override protected List<StusoryInfo> mergeHook(List<StusoryInfo> baseInfos, List<StusoryliInfo> selectedInfos) {	
		return StusoryMerger.mergeWithStusoryli(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
