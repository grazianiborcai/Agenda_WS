package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

final class VisiPayordemMergeToUpdate extends ActionVisitorTemplateMergeV2<PayordemInfo, PayordemInfo> {
	
	public VisiPayordemMergeToUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PayordemInfo>> getActionClassHook() {
		return StdPayordemDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {	
		return PayordemMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
