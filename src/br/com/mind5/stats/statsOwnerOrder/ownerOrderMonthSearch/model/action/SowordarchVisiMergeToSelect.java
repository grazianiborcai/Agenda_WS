package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchMerger;

public final class SowordarchVisiMergeToSelect extends ActionVisitorTemplateMerge<SowordarchInfo, SowordarchInfo> {
	
	public SowordarchVisiMergeToSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option, SowordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowordarchInfo>> getVisitorClassHook() {
		return SowordarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowordarchInfo> mergeHook(List<SowordarchInfo> baseInfos, List<SowordarchInfo> selectedInfos) {	
		return SowordarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
