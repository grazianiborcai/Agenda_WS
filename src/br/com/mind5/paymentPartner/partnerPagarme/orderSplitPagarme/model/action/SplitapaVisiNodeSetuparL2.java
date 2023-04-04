package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.decisionTree.SplitapaNodeSetuparL2;

public final class SplitapaVisiNodeSetuparL2 extends ActionVisitorTemplateAction<SplitapaInfo, SplitapaInfo> {

	public SplitapaVisiNodeSetuparL2(DeciTreeOption<SplitapaInfo> option) {
		super(option, SplitapaInfo.class, SplitapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SplitapaInfo>> getTreeClassHook() {
		return SplitapaNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<SplitapaInfo> toBaseClassHook(List<SplitapaInfo> baseInfos, List<SplitapaInfo> results) {
		return results;
	}
}
