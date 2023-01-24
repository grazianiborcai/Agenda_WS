package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.decisionTree.CrecapaNodeSetuparL2;

public final class CrecapaVisiNodeSetuparL2 extends ActionVisitorTemplateAction<CrecapaInfo, CrecapaInfo> {

	public CrecapaVisiNodeSetuparL2(DeciTreeOption<CrecapaInfo> option) {
		super(option, CrecapaInfo.class, CrecapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecapaInfo>> getTreeClassHook() {
		return CrecapaNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<CrecapaInfo> toBaseClassHook(List<CrecapaInfo> baseInfos, List<CrecapaInfo> results) {
		return results;
	}
}
