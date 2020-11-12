package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparSetterDefault;

final class VisiOwnparEnforceDefault extends ActionVisitorTemplateEnforceV2<OwnparInfo> {
	
	public VisiOwnparEnforceDefault(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OwnparInfo enforceHook(OwnparInfo recordInfo) {
		InfoSetter<OwnparInfo> setter = new OwnparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
