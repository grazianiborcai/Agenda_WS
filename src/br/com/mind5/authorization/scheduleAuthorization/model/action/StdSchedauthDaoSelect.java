package br.com.mind5.authorization.scheduleAuthorization.model.action;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedauthDaoSelect extends ActionStdTemplate<SchedauthInfo> {

	public StdSchedauthDaoSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedauthInfo> buildVisitorHook(DeciTreeOption<SchedauthInfo> option) {
		return new VisiSchedauthDaoSelect(option);
	}
}
