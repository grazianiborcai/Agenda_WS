package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaSetterAuthorization;

public final class CustopaVisiEnforceAuthorization extends ActionVisitorTemplateEnforce<CustopaInfo> {
	
	public CustopaVisiEnforceAuthorization(DeciTreeOption<CustopaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CustopaInfo enforceHook(CustopaInfo recordInfo) {
		InfoSetter<CustopaInfo> setter = new CustopaSetterAuthorization();
		return setter.setAttr(recordInfo);
	}
}
