package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrMerger;

public final class SowusagrVisiMergeCalonth extends ActionVisitorTemplateMerge<SowusagrInfo, CalonthInfo> {
	
	public SowusagrVisiMergeCalonth(DeciTreeOption<SowusagrInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelect.class;
	}
	
	
	
	@Override protected List<SowusagrInfo> mergeHook(List<SowusagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowusagrMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
