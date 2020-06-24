package br.com.mind5.business.scheduleAuthorization.model.action;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedauthObfuscateUser extends ActionStdTemplateV2<SchedauthInfo> {

	public StdSchedauthObfuscateUser(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedauthInfo> buildVisitorHook(DeciTreeOption<SchedauthInfo> option) {
		return new VisiSchedauthObfuscateUser(option);
	}
}
