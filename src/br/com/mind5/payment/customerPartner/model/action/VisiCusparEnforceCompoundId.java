package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparSetterCompoundId;

final class VisiCusparEnforceCompoundId extends ActionVisitorTemplateEnforceV2<CusparInfo> {
	
	public VisiCusparEnforceCompoundId(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusparInfo enforceHook(CusparInfo recordInfo) {
		InfoSetter<CusparInfo> setter = new CusparSetterCompoundId();
		return setter.setAttr(recordInfo);
	}
}
