package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveMerger;

final class VisiSowusiveMergeMonth extends ActionVisitorTemplateMerge<SowusiveInfo, MonthInfo> {
	
	public VisiSowusiveMergeMonth(DeciTreeOption<SowusiveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<SowusiveInfo> mergeHook(List<SowusiveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowusiveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
