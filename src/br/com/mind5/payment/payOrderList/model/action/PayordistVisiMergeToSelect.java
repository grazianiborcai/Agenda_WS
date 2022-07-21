package br.com.mind5.payment.payOrderList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.info.PayordistMerger;

public final class PayordistVisiMergeToSelect extends ActionVisitorTemplateMerge<PayordistInfo, PayordistInfo> {
	
	public PayordistVisiMergeToSelect(DeciTreeOption<PayordistInfo> option) {
		super(option, PayordistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PayordistInfo>> getVisitorClassHook() {
		return PayordistVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordistInfo> mergeHook(List<PayordistInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return PayordistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
