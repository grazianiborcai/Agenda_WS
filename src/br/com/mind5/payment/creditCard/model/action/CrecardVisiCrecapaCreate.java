package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.decisionTree.CrecapaRootCreate;


public final class CrecardVisiCrecapaCreate extends ActionVisitorTemplateAction<CrecardInfo, CrecapaInfo> {
	
	public CrecardVisiCrecapaCreate(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CrecapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecapaInfo>> getTreeClassHook() {
		return CrecapaRootCreate.class;
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CrecapaInfo> selectedInfos) {
		return CrecardMerger.mergeWithCrecapa(baseInfos, selectedInfos);
	}
}
