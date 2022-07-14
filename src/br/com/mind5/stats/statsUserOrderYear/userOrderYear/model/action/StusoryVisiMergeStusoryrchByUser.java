package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryMerger;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.decisionTree.RootStusoryrchSelectByUser;

public final class StusoryVisiMergeStusoryrchByUser extends ActionVisitorTemplateMerge<StusoryInfo, StusoryrchInfo> {
	
	public StusoryVisiMergeStusoryrchByUser(DeciTreeOption<StusoryInfo> option) {
		super(option, StusoryrchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoryrchInfo>> getTreeClassHook() {
		return RootStusoryrchSelectByUser.class;
	}
	
	
	
	@Override protected List<StusoryInfo> mergeHook(List<StusoryInfo> baseInfos, List<StusoryrchInfo> selectedInfos) {	
		return StusoryMerger.mergeWithStusoryrch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
