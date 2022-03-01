package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrMerger;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree.SowordarchRootSelectMonth;

public final class SowordagrVisiMergeSowordarchMonth extends ActionVisitorTemplateMerge<SowordagrInfo, SowordarchInfo> {
	
	public SowordagrVisiMergeSowordarchMonth(DeciTreeOption<SowordagrInfo> option) {
		super(option, SowordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordarchInfo>> getTreeClassHook() {
		return SowordarchRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SowordagrInfo> mergeHook(List<SowordagrInfo> baseInfos, List<SowordarchInfo> selectedInfos) {	
		return SowordagrMerger.mergeWithSowordarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
