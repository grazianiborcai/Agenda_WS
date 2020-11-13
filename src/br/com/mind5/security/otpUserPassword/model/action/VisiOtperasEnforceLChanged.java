package br.com.mind5.security.otpUserPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasSetterLChanged;

final class VisiOtperasEnforceLChanged extends ActionVisitorTemplateEnforce<OtperasInfo> {
	
	public VisiOtperasEnforceLChanged(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtperasInfo enforceHook(OtperasInfo recordInfo) {
		InfoSetter<OtperasInfo> attrSetter = new OtperasSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
