package br.com.mind5.authorization.scheduleAuthorization.model.action;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthSetterObfuscateUser;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class VisiSchedauthObfuscateUser extends ActionVisitorTemplateEnforce<SchedauthInfo> {
	
	public VisiSchedauthObfuscateUser(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedauthInfo enforceHook(SchedauthInfo recordInfo) {
		InfoSetter<SchedauthInfo> setter = new SchedauthSetterObfuscateUser();
		return setter.setAttr(recordInfo);
	}
}
