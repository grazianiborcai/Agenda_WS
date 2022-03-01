package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrMerger;

public final class SowordagrVisiMergeToSelect extends ActionVisitorTemplateMerge<SowordagrInfo, SowordagrInfo> {
	
	public SowordagrVisiMergeToSelect(DeciTreeOption<SowordagrInfo> option) {
		super(option, SowordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowordagrInfo>> getVisitorClassHook() {
		return SowordagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowordagrInfo> mergeHook(List<SowordagrInfo> baseInfos, List<SowordagrInfo> selectedInfos) {	
		return SowordagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
