package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStore.info.BostodMerger;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectL2m;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBostodMergeCalonthL2m extends ActionVisitorTemplateMerge<BostodInfo, CalonthInfo> {
	
	public VisiBostodMergeCalonthL2m(DeciTreeOption<BostodInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectL2m.class;
	}
	
	
	
	@Override protected List<BostodInfo> mergeHook(List<BostodInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return BostodMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
