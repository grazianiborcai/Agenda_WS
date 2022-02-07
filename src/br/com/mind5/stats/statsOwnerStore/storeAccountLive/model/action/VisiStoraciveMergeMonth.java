package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveMerger;

final class VisiStoraciveMergeMonth extends ActionVisitorTemplateMerge<StoraciveInfo, MonthInfo> {
	
	public VisiStoraciveMergeMonth(DeciTreeOption<StoraciveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<StoraciveInfo> mergeHook(List<StoraciveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return StoraciveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
