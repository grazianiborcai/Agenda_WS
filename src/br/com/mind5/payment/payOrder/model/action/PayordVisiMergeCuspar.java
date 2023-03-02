package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

public final class PayordVisiMergeCuspar extends ActionVisitorTemplateMerge<PayordInfo, CusparInfo> {
	
	public PayordVisiMergeCuspar(DeciTreeOption<PayordInfo> option) {
		super(option, CusparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return PayordMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
