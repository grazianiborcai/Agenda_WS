package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.action.SchedauthVisiDaoSelect;
import br.com.mind5.authorization.scheduleAuthorization.model.action.SchedauthVisiMergeUsername;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedauthCheckExist extends ModelCheckerTemplateAction<SchedauthInfo, SchedauthInfo> {
	
	public SchedauthCheckExist(ModelCheckerOption option) {
		super(option, SchedauthInfo.class);
	}
	

	
	@Override protected ActionStd<SchedauthInfo> buildActionHook(DeciTreeOption<SchedauthInfo> option) {
		ActionStd<SchedauthInfo> mergeUsername = new ActionStdCommom<SchedauthInfo>(option, SchedauthVisiMergeUsername.class);
		ActionLazy<SchedauthInfo> select = new ActionLazyCommom<SchedauthInfo>(option, SchedauthVisiDaoSelect.class);
		
		mergeUsername.addPostAction(select);
		return mergeUsername;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_AUTH_USER_AUTHORIZED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_AUTH_NOT_AUTHORIZED;
	}
}
