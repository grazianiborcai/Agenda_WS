package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree.RecipaRootCreateFromStore;

public final class CusparVisiRecipaCreate extends ActionVisitorTemplateAction<CusparInfo, RecipaInfo> {
	public CusparVisiRecipaCreate(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class, RecipaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RecipaInfo>> getTreeClassHook() {
		return RecipaRootCreateFromStore.class;
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<RecipaInfo> results) {
		return baseInfos;
//		return StoparMerger.mergeWithRecipa(baseInfos, results);
	}
}
