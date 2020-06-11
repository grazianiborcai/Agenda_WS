package br.com.mind5.security.otpProspectStore.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.OtporeSetterLChanged;

final class VisiOtporeEnforceLChanged extends ActionVisitorTemplateEnforceV2<OtporeInfo> {
	
	public VisiOtporeEnforceLChanged(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtporeInfo enforceHook(OtporeInfo recordInfo) {
		InfoSetter<OtporeInfo> attrSetter = new OtporeSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
