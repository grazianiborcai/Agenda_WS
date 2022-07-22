package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.util.List;


import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemMerger;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipRead;

public final class PaytusemVisiMergeOrdmoip extends ActionVisitorTemplateMerge<PaytusemInfo, OrdmoipInfo> {
	
	public PaytusemVisiMergeOrdmoip(DeciTreeOption<PaytusemInfo> option) {
		super(option, OrdmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdmoipInfo>> getTreeClassHook() {
		return RootOrdmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> mergeHook(List<PaytusemInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {	
		return PaytusemMerger.mergeWithOrdmoip(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
