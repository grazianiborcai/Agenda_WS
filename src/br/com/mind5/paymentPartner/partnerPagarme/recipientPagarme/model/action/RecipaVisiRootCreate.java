package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree.RecipaRootCreate;

public final class RecipaVisiRootCreate extends ActionVisitorTemplateAction<RecipaInfo, RecipaInfo> {

	public RecipaVisiRootCreate(DeciTreeOption<RecipaInfo> option) {
		super(option, RecipaInfo.class, RecipaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RecipaInfo>> getTreeClassHook() {
		return RecipaRootCreate.class;
	}
	
	
	
	@Override protected List<RecipaInfo> toBaseClassHook(List<RecipaInfo> baseInfos, List<RecipaInfo> results) {
		return results;
	}
}
