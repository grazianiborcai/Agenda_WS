package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordMerger;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.decisionTree.RootSowordiveSelect;

final class VisiSowordMergeSowordiveMonth extends ActionVisitorTemplateMerge<SowordInfo, SowordiveInfo> {
	
	public VisiSowordMergeSowordiveMonth(DeciTreeOption<SowordInfo> option) {
		super(option, SowordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordiveInfo>> getTreeClassHook() {
		return RootSowordiveSelect.class;
	}
	
	
	
	@Override protected List<SowordInfo> mergeHook(List<SowordInfo> baseInfos, List<SowordiveInfo> selectedInfos) {	
		return SowordMerger.mergeWithSowordive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
