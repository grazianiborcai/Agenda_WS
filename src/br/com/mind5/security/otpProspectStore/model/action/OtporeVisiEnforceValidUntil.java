package br.com.mind5.security.otpProspectStore.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.OtporeSetterValidUntil;

public final class OtporeVisiEnforceValidUntil extends ActionVisitorTemplateEnforce<OtporeInfo> {
	
	public OtporeVisiEnforceValidUntil(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OtporeInfo enforceHook(OtporeInfo recordInfo) {
		InfoSetter<OtporeInfo> attrSetter = new OtporeSetterValidUntil();
		return attrSetter.setAttr(recordInfo);
	}
}
