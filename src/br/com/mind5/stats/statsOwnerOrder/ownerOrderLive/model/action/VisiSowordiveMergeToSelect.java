package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveMerger;

final class VisiSowordiveMergeToSelect extends ActionVisitorTemplateMerge<SowordiveInfo, SowordiveInfo> {
	
	public VisiSowordiveMergeToSelect(DeciTreeOption<SowordiveInfo> option) {
		super(option, SowordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowordiveInfo>> getActionClassHook() {
		return StdSowordiveDaoSelect.class;
	}
	
	
	
	@Override protected List<SowordiveInfo> mergeHook(List<SowordiveInfo> baseInfos, List<SowordiveInfo> selectedInfos) {	
		return SowordiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
