package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.PayparRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapMerger;

public final class StoparnapVisiMergePaypar extends ActionVisitorTemplateMerge<StoparnapInfo, PayparInfo> {
	
	public StoparnapVisiMergePaypar(DeciTreeOption<StoparnapInfo> option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return PayparRootSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> baseInfos, List<PayparInfo> selectedInfos) {	
		return StoparnapMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
