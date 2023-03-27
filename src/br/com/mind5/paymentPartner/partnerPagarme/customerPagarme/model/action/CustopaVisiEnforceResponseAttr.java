package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaSetterResponseAttr;

public final class CustopaVisiEnforceResponseAttr extends ActionVisitorTemplateEnforce<CustopaInfo> {
	
	public CustopaVisiEnforceResponseAttr(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CustopaInfo enforceHook(CustopaInfo recordInfo) {
		InfoSetter<CustopaInfo> setter = new CustopaSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
