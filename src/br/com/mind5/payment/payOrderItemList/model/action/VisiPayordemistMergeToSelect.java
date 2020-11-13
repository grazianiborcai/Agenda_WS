package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistMerger;

final class VisiPayordemistMergeToSelect extends ActionVisitorTemplateMerge<PayordemistInfo, PayordemistInfo> {
	
	public VisiPayordemistMergeToSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordemistInfo>> getActionClassHook() {
		return StdPayordemistDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordemistInfo> mergeHook(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return PayordemistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
