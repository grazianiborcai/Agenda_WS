package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparCopier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.SetuparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipMerger;

public final class PaymoipVisiMergeSetupar extends ActionVisitorTemplateMerge<PaymoipInfo, SetuparInfo> {
	
	public PaymoipVisiMergeSetupar(DeciTreeOption<PaymoipInfo> option) {
		super(option, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return SetuparRootSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<PaymoipInfo> baseInfos) {
		return SetuparCopier.copyFromPaymoip(baseInfos);	
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSetupar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
