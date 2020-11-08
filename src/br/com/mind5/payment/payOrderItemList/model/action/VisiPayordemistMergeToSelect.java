package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistMerger;

final class VisiPayordemistMergeToSelect extends ActionVisitorTemplateMergeV2<PayordemistInfo, PayordemistInfo> {
	
	public VisiPayordemistMergeToSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PayordemistInfo>> getActionClassHook() {
		return StdPayordemistDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordemistInfo> mergeHook(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return PayordemistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
