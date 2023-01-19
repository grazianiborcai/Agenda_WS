package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootUpdatePartner;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;


public final class RecipaVisiBankaccUpdatePartner extends ActionVisitorTemplateAction<RecipaInfo, BankaccInfo> {
	
	public RecipaVisiBankaccUpdatePartner(DeciTreeOption<RecipaInfo> option) {
		super(option, RecipaInfo.class, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootUpdatePartner.class;
	}
	
	
	
	@Override protected List<RecipaInfo> toBaseClassHook(List<RecipaInfo> baseInfos, List<BankaccInfo> selectedInfos) {
		return baseInfos;
	}
}
