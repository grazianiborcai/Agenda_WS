package br.com.mind5.security.otp.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.info.OtpSetterLength;

final class VisiOtpEnforceLength extends ActionVisitorTemplateEnforceV2<OtpInfo> {
	
	public VisiOtpEnforceLength(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtpInfo enforceHook(OtpInfo recordInfo) {
		InfoSetter<OtpInfo> attrSetter = new OtpSetterLength();
		return attrSetter.setAttr(recordInfo);
	}
}