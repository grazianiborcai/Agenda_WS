package br.com.mind5.authorization.scheduleAuthorization.model.action;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedauthMergeUsername extends ActionStdTemplateV2<SchedauthInfo> {

	public StdSchedauthMergeUsername(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedauthInfo> buildVisitorHook(DeciTreeOption<SchedauthInfo> option) {
		return new VisiSchedauthMergeUsername(option);
	}
}
