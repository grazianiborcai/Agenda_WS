package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveMerger;

public final class SowordiveVisiMergeToSelect extends ActionVisitorTemplateMerge<SowordiveInfo, SowordiveInfo> {
	
	public SowordiveVisiMergeToSelect(DeciTreeOption<SowordiveInfo> option) {
		super(option, SowordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowordiveInfo>> getVisitorClassHook() {
		return SowordiveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowordiveInfo> mergeHook(List<SowordiveInfo> baseInfos, List<SowordiveInfo> selectedInfos) {	
		return SowordiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
