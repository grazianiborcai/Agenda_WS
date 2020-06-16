package br.com.mind5.security.otpUserPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasSetterValidUntil;

final class VisiOtperasEnforceValidUntil extends ActionVisitorTemplateEnforceV2<OtperasInfo> {
	
	public VisiOtperasEnforceValidUntil(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtperasInfo enforceHook(OtperasInfo recordInfo) {
		InfoSetter<OtperasInfo> attrSetter = new OtperasSetterValidUntil();
		return attrSetter.setAttr(recordInfo);
	}
}
