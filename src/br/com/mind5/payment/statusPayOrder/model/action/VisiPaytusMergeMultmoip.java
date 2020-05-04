package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.RootMultmoipRead;

final class VisiPaytusMergeMultmoip extends ActionVisitorTemplateMergeV2<PaytusInfo, MultmoipInfo> {
	
	public VisiPaytusMergeMultmoip(DeciTreeOption<PaytusInfo> option) {
		super(option, MultmoipInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MultmoipInfo>> getTreeClassHook() {
		return RootMultmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> baseInfos, List<MultmoipInfo> selectedInfos) {	
		return PaytusMerger.mergeWithMultmoip(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
