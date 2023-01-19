package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootSearchStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaMerger;

public final class RecipaVisiMergeBankacc extends ActionVisitorTemplateMerge<RecipaInfo, BankaccInfo> {
	
	public RecipaVisiMergeBankacc(DeciTreeOption<RecipaInfo> option) {
		super(option, BankaccInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootSearchStore.class;
	}
	
	
	
	@Override protected List<RecipaInfo> mergeHook(List<RecipaInfo> baseInfos, List<BankaccInfo> selectedInfos) {	
		return RecipaMerger.mergeWithBankacc(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
