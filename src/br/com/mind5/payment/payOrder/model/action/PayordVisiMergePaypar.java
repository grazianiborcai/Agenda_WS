package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.PayparRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

public final class PayordVisiMergePaypar extends ActionVisitorTemplateMerge<PayordInfo, PayparInfo> {
	
	public PayordVisiMergePaypar(DeciTreeOption<PayordInfo> option) {
		super(option, PayparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return PayparRootSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<PayparInfo> selectedInfos) {	
		return PayordMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
