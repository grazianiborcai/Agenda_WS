package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordMerger;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.decisionTree.RootSowordiveSelectMonth;

final class VisiSowordMergeSowordive extends ActionVisitorTemplateMerge<SowordInfo, SowordiveInfo> {
	
	public VisiSowordMergeSowordive(DeciTreeOption<SowordInfo> option) {
		super(option, SowordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordiveInfo>> getTreeClassHook() {
		return RootSowordiveSelectMonth.class;
	}
	
	
	
	@Override protected List<SowordInfo> mergeHook(List<SowordInfo> baseInfos, List<SowordiveInfo> selectedInfos) {	
		return SowordMerger.mergeWithSowordive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
