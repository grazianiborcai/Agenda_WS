package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.decisionTree.SchedauthRootMove;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedauthCheckAuth extends ModelCheckerTemplateAction<SchedauthInfo, SchedauthInfo> {
	
	public SchedauthCheckAuth(ModelCheckerOption option) {
		super(option, SchedauthInfo.class);
	}
	

	
	@Override protected ActionStd<SchedauthInfo> buildActionHook(DeciTreeOption<SchedauthInfo> option) {
		ActionStd<SchedauthInfo> select = new SchedauthRootMove(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_AUTH_USER_AUTHORIZED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_AUTH_NOT_AUTHORIZED;
	}
}
