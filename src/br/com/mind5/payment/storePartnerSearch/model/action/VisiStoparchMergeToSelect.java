package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchMerger;

final class VisiStoparchMergeToSelect extends ActionVisitorTemplateMergeV2<StoparchInfo, StoparchInfo> {
	
	public VisiStoparchMergeToSelect(DeciTreeOption<StoparchInfo> option) {
		super(option, StoparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoparchInfo>> getActionClassHook() {
		return StdStoparchDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparchInfo> mergeHook(List<StoparchInfo> baseInfos, List<StoparchInfo> selectedInfos) {	
		return StoparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
