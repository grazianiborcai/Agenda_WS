package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotarchMergeToSelect extends ActionVisitorTemplateMergeV2<StowotarchInfo, StowotarchInfo> {
	
	public VisiStowotarchMergeToSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StowotarchInfo>> getActionClassHook() {
		return StdStowotarchDaoSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> mergeHook(List<StowotarchInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
