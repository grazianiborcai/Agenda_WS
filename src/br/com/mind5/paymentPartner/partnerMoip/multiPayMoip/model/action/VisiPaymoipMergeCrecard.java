package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.RootCrecardSelect;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipMerger;

final class VisiPaymoipMergeCrecard extends ActionVisitorTemplateMerge<PaymoipInfo, CrecardInfo> {
	
	public VisiPaymoipMergeCrecard(DeciTreeOption<PaymoipInfo> option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return RootCrecardSelect.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithCrecard(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
