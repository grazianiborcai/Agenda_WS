package br.com.mind5.message.emailUserOtp.model.action;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmusotpEnforceEmabody extends ActionStdTemplate<EmusotpInfo> {

	public StdEmusotpEnforceEmabody(DeciTreeOption<EmusotpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmusotpInfo> buildVisitorHook(DeciTreeOption<EmusotpInfo> option) {
		return new VisiEmusotpEnforceEmabody(option);
	}
}
