package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;

final class VisiStoplisMergeToSelect extends ActionVisitorTemplateMergeV2<StoplisInfo, StoplisInfo> {
	
	public VisiStoplisMergeToSelect(DeciTreeOption<StoplisInfo> option) {
		super(option, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoplisInfo>> getActionClassHook() {
		return StdStoplisDaoSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> baseInfos, List<StoplisInfo> selectedInfos) {	
		return StoplisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
