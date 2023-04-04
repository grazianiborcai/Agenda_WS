package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaSetterSplit;

public final class SplitapaVisiEnforceSplit extends ActionVisitorTemplateEnforce<SplitapaInfo> {
	
	public SplitapaVisiEnforceSplit(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SplitapaInfo enforceHook(SplitapaInfo recordInfo) {
		InfoSetter<SplitapaInfo> setter = new SplitapaSetterSplit();
		return setter.setAttr(recordInfo);
	}
}
