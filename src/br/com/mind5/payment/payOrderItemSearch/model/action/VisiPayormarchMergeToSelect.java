package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchMerger;

final class VisiPayormarchMergeToSelect extends ActionVisitorTemplateMerge<PayormarchInfo, PayormarchInfo> {
	
	public VisiPayormarchMergeToSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayormarchInfo>> getActionClassHook() {
		return StdPayormarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> mergeHook(List<PayormarchInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return PayormarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
