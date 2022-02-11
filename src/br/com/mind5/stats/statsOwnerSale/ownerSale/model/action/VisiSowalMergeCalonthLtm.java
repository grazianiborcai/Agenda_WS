package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalMerger;

final class VisiSowalMergeCalonthLtm extends ActionVisitorTemplateMerge<SowalInfo, CalonthInfo> {
	
	public VisiSowalMergeCalonthLtm(DeciTreeOption<SowalInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<SowalInfo> mergeHook(List<SowalInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowalMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
