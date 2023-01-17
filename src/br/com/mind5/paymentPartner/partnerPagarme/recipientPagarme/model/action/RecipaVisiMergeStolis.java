package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaMerger;

public final class RecipaVisiMergeStolis extends ActionVisitorTemplateMerge<RecipaInfo, StolisInfo> {
	
	public RecipaVisiMergeStolis(DeciTreeOption<RecipaInfo> option) {
		super(option, StolisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}
	
	
	
	@Override protected List<RecipaInfo> mergeHook(List<RecipaInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return RecipaMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
