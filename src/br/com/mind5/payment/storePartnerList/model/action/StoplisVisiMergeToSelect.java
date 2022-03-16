package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;

public final class StoplisVisiMergeToSelect extends ActionVisitorTemplateMerge<StoplisInfo, StoplisInfo> {
	
	public StoplisVisiMergeToSelect(DeciTreeOption<StoplisInfo> option) {
		super(option, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoplisInfo>> getVisitorClassHook() {
		return StoplisVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> baseInfos, List<StoplisInfo> selectedInfos) {	
		return StoplisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
