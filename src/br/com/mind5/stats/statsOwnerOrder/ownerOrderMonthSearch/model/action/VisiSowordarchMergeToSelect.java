package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchMerger;

final class VisiSowordarchMergeToSelect extends ActionVisitorTemplateMerge<SowordarchInfo, SowordarchInfo> {
	
	public VisiSowordarchMergeToSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option, SowordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowordarchInfo>> getActionClassHook() {
		return StdSowordarchDaoSelect.class;
	}
	
	
	
	@Override protected List<SowordarchInfo> mergeHook(List<SowordarchInfo> baseInfos, List<SowordarchInfo> selectedInfos) {	
		return SowordarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
