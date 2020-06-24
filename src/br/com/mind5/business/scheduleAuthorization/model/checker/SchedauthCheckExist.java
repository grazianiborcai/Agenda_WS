package br.com.mind5.business.scheduleAuthorization.model.checker;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.model.action.LazySchedauthDaoSelect;
import br.com.mind5.business.scheduleAuthorization.model.action.StdSchedauthMergeUsername;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedauthCheckExist extends ModelCheckerTemplateActionV2<SchedauthInfo, SchedauthInfo> {
	
	public SchedauthCheckExist(ModelCheckerOption option) {
		super(option, SchedauthInfo.class);
	}
	

	
	@Override protected ActionStdV1<SchedauthInfo> buildActionHook(DeciTreeOption<SchedauthInfo> option) {
		ActionStdV1<SchedauthInfo> mergeUsername = new StdSchedauthMergeUsername(option);
		ActionLazyV1<SchedauthInfo> select = new LazySchedauthDaoSelect(option.conn, option.schemaName);
		
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
