package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree.StusorygrarchRootSelectByUser;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchMerger;

public final class StusoryrchVisiMergeStusorygrarch extends ActionVisitorTemplateMerge<StusoryrchInfo, StusorygrarchInfo> {
	
	public StusoryrchVisiMergeStusorygrarch(DeciTreeOption<StusoryrchInfo> option) {
		super(option, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygrarchInfo>> getTreeClassHook() {
		return StusorygrarchRootSelectByUser.class;
	}
	
	
	
	@Override protected List<StusoryrchInfo> mergeHook(List<StusoryrchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {	
		return StusoryrchMerger.mergeWithStusorygrarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
