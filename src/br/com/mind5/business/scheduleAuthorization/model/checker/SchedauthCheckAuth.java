package br.com.mind5.business.scheduleAuthorization.model.checker;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.model.decisionTree.RootSchedauthSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedauthCheckAuth extends ModelCheckerTemplateActionV2<SchedauthInfo, SchedauthInfo> {
	
	public SchedauthCheckAuth(ModelCheckerOption option) {
		super(option, SchedauthInfo.class);
	}
	

	
	@Override protected ActionStdV1<SchedauthInfo> buildActionHook(DeciTreeOption<SchedauthInfo> option) {
		ActionStdV1<SchedauthInfo> select = new RootSchedauthSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_AUTH_USER_AUTHORIZED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_AUTH_NOT_AUTHORIZED;
	}
}
