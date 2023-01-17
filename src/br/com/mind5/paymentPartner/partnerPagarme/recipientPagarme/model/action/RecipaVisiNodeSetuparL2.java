package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree.RecipaNodeSetuparL2;

public final class RecipaVisiNodeSetuparL2 extends ActionVisitorTemplateAction<RecipaInfo, RecipaInfo> {

	public RecipaVisiNodeSetuparL2(DeciTreeOption<RecipaInfo> option) {
		super(option, RecipaInfo.class, RecipaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RecipaInfo>> getTreeClassHook() {
		return RecipaNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<RecipaInfo> toBaseClassHook(List<RecipaInfo> baseInfos, List<RecipaInfo> results) {
		return results;
	}
}
