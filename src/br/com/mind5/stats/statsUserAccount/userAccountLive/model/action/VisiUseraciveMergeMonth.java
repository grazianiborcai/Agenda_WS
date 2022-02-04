package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveMerger;

final class VisiUseraciveMergeMonth extends ActionVisitorTemplateMerge<UseraciveInfo, MonthInfo> {
	
	public VisiUseraciveMergeMonth(DeciTreeOption<UseraciveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<UseraciveInfo> mergeHook(List<UseraciveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return UseraciveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
