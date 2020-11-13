package br.com.mind5.authorization.scheduleAuthorization.model.action;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedauthMergeToSelect extends ActionStdTemplate<SchedauthInfo> {

	public StdSchedauthMergeToSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedauthInfo> buildVisitorHook(DeciTreeOption<SchedauthInfo> option) {
		return new VisiSchedauthMergeToSelect(option);
	}
}
