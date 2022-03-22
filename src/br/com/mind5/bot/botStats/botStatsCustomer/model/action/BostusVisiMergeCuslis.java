package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusMerger;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostusVisiMergeCuslis extends ActionVisitorTemplateMerge<BostusInfo, CuslisInfo> {
	
	public BostusVisiMergeCuslis(DeciTreeOption<BostusInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSearch.class;
	}
	
	
	
	@Override protected List<BostusInfo> mergeHook(List<BostusInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return BostusMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
