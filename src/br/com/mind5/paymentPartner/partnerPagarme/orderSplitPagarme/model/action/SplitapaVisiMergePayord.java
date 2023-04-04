package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaMerger;

public final class SplitapaVisiMergePayord extends ActionVisitorTemplateMerge<SplitapaInfo, PayordInfo> {
	
	public SplitapaVisiMergePayord(DeciTreeOption<SplitapaInfo> option) {
		super(option, PayordInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordRootSelect.class;
	}
	
	
	
	@Override protected List<SplitapaInfo> mergeHook(List<SplitapaInfo> baseInfos, List<PayordInfo> selectedInfos) {	
		return SplitapaMerger.mergeWithPayord(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
