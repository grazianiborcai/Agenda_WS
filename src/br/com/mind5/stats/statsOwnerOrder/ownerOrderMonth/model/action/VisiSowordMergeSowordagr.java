package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordMerger;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree.RootSowordagrSelect;

final class VisiSowordMergeSowordagr extends ActionVisitorTemplateMerge<SowordInfo, SowordagrInfo> {
	
	public VisiSowordMergeSowordagr(DeciTreeOption<SowordInfo> option) {
		super(option, SowordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordagrInfo>> getTreeClassHook() {
		return RootSowordagrSelect.class;
	}
	
	
	
	@Override protected List<SowordInfo> mergeHook(List<SowordInfo> baseInfos, List<SowordagrInfo> selectedInfos) {	
		return SowordMerger.mergeWithSowordagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
