package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodMerger;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBostodMergeStolis extends ActionVisitorTemplateMerge<BostodInfo, StolisInfo> {
	
	public VisiBostodMergeStolis(DeciTreeOption<BostodInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSearch.class;
	}
	
	
	
	@Override protected List<BostodInfo> mergeHook(List<BostodInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return BostodMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
