package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.decisionTree.PayordistRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaMerger;

public final class OrdapaVisiMergePayordist extends ActionVisitorTemplateMerge<OrdapaInfo, PayordistInfo> {
	
	public OrdapaVisiMergePayordist(DeciTreeOption<OrdapaInfo> option) {
		super(option, PayordistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordistInfo>> getTreeClassHook() {
		return PayordistRootSelect.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> mergeHook(List<OrdapaInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return OrdapaMerger.mergeWithPayordist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
