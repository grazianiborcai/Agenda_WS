package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree.RootStusorygrarchSelectByUser;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchMerger;

final class VisiStusoryrchMergeStusorygrarch extends ActionVisitorTemplateMerge<StusoryrchInfo, StusorygrarchInfo> {
	
	public VisiStusoryrchMergeStusorygrarch(DeciTreeOption<StusoryrchInfo> option) {
		super(option, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygrarchInfo>> getTreeClassHook() {
		return RootStusorygrarchSelectByUser.class;
	}
	
	
	
	@Override protected List<StusoryrchInfo> mergeHook(List<StusoryrchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {	
		return StusoryrchMerger.mergeWithStusorygrarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
