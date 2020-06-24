package br.com.mind5.business.scheduleAuthorization.model.action;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.info.SchedauthSetterObfuscateUser;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedauthObfuscateUser extends ActionVisitorTemplateEnforceV2<SchedauthInfo> {
	
	public VisiSchedauthObfuscateUser(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedauthInfo enforceHook(SchedauthInfo recordInfo) {
		InfoSetter<SchedauthInfo> setter = new SchedauthSetterObfuscateUser();
		return setter.setAttr(recordInfo);
	}
}
