package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.decisionTree.MktparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipMerger;

public final class PaymoipVisiMergeSyspar extends ActionVisitorTemplateMerge<PaymoipInfo, MktparInfo> {
	
	public PaymoipVisiMergeSyspar(DeciTreeOption<PaymoipInfo> option) {
		super(option, MktparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MktparInfo>> getTreeClassHook() {
		return MktparRootSelect.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> baseInfos, List<MktparInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSyspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
