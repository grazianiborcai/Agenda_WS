package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchMerger;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree.RootStusorygerchSelectByUser;

public final class StusoryrchVisiMergeStusorygerch extends ActionVisitorTemplateMerge<StusoryrchInfo, StusorygerchInfo> {
	
	public StusoryrchVisiMergeStusorygerch(DeciTreeOption<StusoryrchInfo> option) {
		super(option, StusorygerchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygerchInfo>> getTreeClassHook() {
		return RootStusorygerchSelectByUser.class;
	}
	
	
	
	@Override protected List<StusoryrchInfo> mergeHook(List<StusoryrchInfo> baseInfos, List<StusorygerchInfo> selectedInfos) {	
		return StusoryrchMerger.mergeWithStusorygerch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
