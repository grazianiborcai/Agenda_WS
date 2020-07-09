package br.com.mind5.authorization.scheduleAuthorization.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedauthSetterObfuscateUser extends InfoSetterTemplate<SchedauthInfo> {
	
	@Override protected SchedauthInfo setAttrHook(SchedauthInfo recordInfo) {
		recordInfo.codUser = DefaultValue.number();
		return recordInfo;
	}	
}
