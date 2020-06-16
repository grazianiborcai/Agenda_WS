package br.com.mind5.message.emailUserOtp.model.action;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmusotpEnforceEmabody extends ActionStdTemplateV2<EmusotpInfo> {

	public StdEmusotpEnforceEmabody(DeciTreeOption<EmusotpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmusotpInfo> buildVisitorHook(DeciTreeOption<EmusotpInfo> option) {
		return new VisiEmusotpEnforceEmabody(option);
	}
}
