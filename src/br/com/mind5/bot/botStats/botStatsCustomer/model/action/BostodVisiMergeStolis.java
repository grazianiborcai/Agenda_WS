package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusMerger;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostodVisiMergeStolis extends ActionVisitorTemplateMerge<BostusInfo, StolisInfo> {
	
	public BostodVisiMergeStolis(DeciTreeOption<BostusInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSearch.class;
	}
	
	
	
	@Override protected List<BostusInfo> mergeHook(List<BostusInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return BostusMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
