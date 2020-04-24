package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolarchMergeToSelect extends ActionVisitorTemplateMergeV2<StolarchInfo, StolarchInfo> {
	
	public VisiStolarchMergeToSelect(DeciTreeOption<StolarchInfo> option) {
		super(option, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StolarchInfo>> getActionClassHook() {
		return StdStolarchDaoSelect.class;
	}
	
	
	
	@Override protected List<StolarchInfo> mergeHook(List<StolarchInfo> baseInfos, List<StolarchInfo> selectedInfos) {	
		return StolarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
