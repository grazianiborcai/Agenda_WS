package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;

final class VisiStoplisMergeToSelect extends ActionVisitorTemplateMerge<StoplisInfo, StoplisInfo> {
	
	public VisiStoplisMergeToSelect(DeciTreeOption<StoplisInfo> option) {
		super(option, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoplisInfo>> getActionClassHook() {
		return StdStoplisDaoSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> baseInfos, List<StoplisInfo> selectedInfos) {	
		return StoplisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
