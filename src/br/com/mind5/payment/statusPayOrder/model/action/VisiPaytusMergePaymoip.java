package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree.RootPaymoipRead;

final class VisiPaytusMergePaymoip extends ActionVisitorTemplateMergeV2<PaytusInfo, PaymoipInfo> {
	
	public VisiPaytusMergePaymoip(DeciTreeOption<PaytusInfo> option) {
		super(option, PaymoipInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaymoipInfo>> getTreeClassHook() {
		return RootPaymoipRead.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> baseInfos, List<PaymoipInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPaymoip(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
