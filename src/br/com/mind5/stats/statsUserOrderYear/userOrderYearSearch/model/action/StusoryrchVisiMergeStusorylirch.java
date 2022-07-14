package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree.StusorylirchRootSelectByUser;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchMerger;

public final class StusoryrchVisiMergeStusorylirch extends ActionVisitorTemplateMerge<StusoryrchInfo, StusorylirchInfo> {
	
	public StusoryrchVisiMergeStusorylirch(DeciTreeOption<StusoryrchInfo> option) {
		super(option, StusorylirchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorylirchInfo>> getTreeClassHook() {
		return StusorylirchRootSelectByUser.class;
	}
	
	
	
	@Override protected List<StusoryrchInfo> mergeHook(List<StusoryrchInfo> baseInfos, List<StusorylirchInfo> selectedInfos) {	
		return StusoryrchMerger.mergeWithStusorylirch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
