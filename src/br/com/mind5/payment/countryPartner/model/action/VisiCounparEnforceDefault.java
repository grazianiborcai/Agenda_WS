package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparSetterDefault;

final class VisiCounparEnforceDefault extends ActionVisitorTemplateEnforceV2<CounparInfo> {
	
	public VisiCounparEnforceDefault(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CounparInfo enforceHook(CounparInfo recordInfo) {
		InfoSetter<CounparInfo> setter = new CounparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
