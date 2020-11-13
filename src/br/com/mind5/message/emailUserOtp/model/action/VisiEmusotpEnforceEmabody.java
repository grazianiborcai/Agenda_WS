package br.com.mind5.message.emailUserOtp.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.message.emailUserOtp.info.EmusotpSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmusotpEnforceEmabody extends ActionVisitorTemplateEnforce<EmusotpInfo> {
	
	public VisiEmusotpEnforceEmabody(DeciTreeOption<EmusotpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmusotpInfo enforceHook(EmusotpInfo recordInfo) {
		InfoSetter<EmusotpInfo> attrSetter = new EmusotpSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
