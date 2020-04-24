package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.RootStoparchSelect;

final class VisiStoplisMergeStoparch extends ActionVisitorTemplateMergeV2<StoplisInfo, StoparchInfo> {
	
	public VisiStoplisMergeStoparch(DeciTreeOption<StoplisInfo> option) {
		super(option, StoparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparchInfo>> getTreeClassHook() {
		return RootStoparchSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> baseInfos, List<StoparchInfo> selectedInfos) {	
		return StoplisMerger.mergeWithStoparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
