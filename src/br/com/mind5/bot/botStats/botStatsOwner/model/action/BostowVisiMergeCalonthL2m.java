package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.bot.botStats.botStatsOwner.info.BostowMerger;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectL2mNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostowVisiMergeCalonthL2m extends ActionVisitorTemplateMerge<BostowInfo, CalonthInfo> {
	
	public BostowVisiMergeCalonthL2m(DeciTreeOption<BostowInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectL2mNow.class;
	}
	
	
	
	@Override protected List<BostowInfo> mergeHook(List<BostowInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return BostowMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
