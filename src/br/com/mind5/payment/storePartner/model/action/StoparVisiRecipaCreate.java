package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree.RecipaRootCreateFromStore;

public final class StoparVisiRecipaCreate extends ActionVisitorTemplateAction<StoparInfo, RecipaInfo> {
	public StoparVisiRecipaCreate(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class, RecipaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RecipaInfo>> getTreeClassHook() {
		return RecipaRootCreateFromStore.class;
	}
	
	
	
	@Override protected List<StoparInfo> toBaseClassHook(List<StoparInfo> baseInfos, List<RecipaInfo> results) {
		return StoparMerger.mergeWithRecipa(baseInfos, results);
	}
}
