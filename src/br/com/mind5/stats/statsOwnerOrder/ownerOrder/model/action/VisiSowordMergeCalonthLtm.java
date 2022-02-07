package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordMerger;

final class VisiSowordMergeCalonthLtm extends ActionVisitorTemplateMerge<SowordInfo, CalonthInfo> {
	
	public VisiSowordMergeCalonthLtm(DeciTreeOption<SowordInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<SowordInfo> mergeHook(List<SowordInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowordMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
