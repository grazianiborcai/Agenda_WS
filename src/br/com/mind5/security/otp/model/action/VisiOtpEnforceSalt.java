package br.com.mind5.security.otp.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.info.OtpSetterSalt;

final class VisiOtpEnforceSalt extends ActionVisitorTemplateEnforce<OtpInfo> {
	
	public VisiOtpEnforceSalt(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtpInfo enforceHook(OtpInfo recordInfo) {
		InfoSetter<OtpInfo> attrSetter = new OtpSetterSalt();
		return attrSetter.setAttr(recordInfo);
	}
}
