package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotMerger;

final class VisiSowotMergeCalonthLtm extends ActionVisitorTemplateMerge<SowotInfo, CalonthInfo> {
	
	public VisiSowotMergeCalonthLtm(DeciTreeOption<SowotInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowotMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
