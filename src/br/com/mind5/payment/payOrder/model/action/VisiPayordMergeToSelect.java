package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

final class VisiPayordMergeToSelect extends ActionVisitorTemplateMerge<PayordInfo, PayordInfo> {
	
	public VisiPayordMergeToSelect(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordInfo>> getActionClassHook() {
		return StdPayordDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {	
		return PayordMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
