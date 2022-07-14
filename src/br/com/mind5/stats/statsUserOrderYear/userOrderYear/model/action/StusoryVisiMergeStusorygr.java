package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryMerger;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.decisionTree.RootStusorygrSelect;

public final class StusoryVisiMergeStusorygr extends ActionVisitorTemplateMerge<StusoryInfo, StusorygrInfo> {
	
	public StusoryVisiMergeStusorygr(DeciTreeOption<StusoryInfo> option) {
		super(option, StusorygrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygrInfo>> getTreeClassHook() {
		return RootStusorygrSelect.class;
	}
	
	
	
	@Override protected List<StusoryInfo> mergeHook(List<StusoryInfo> baseInfos, List<StusorygrInfo> selectedInfos) {	
		return StusoryMerger.mergeWithStusorygr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
