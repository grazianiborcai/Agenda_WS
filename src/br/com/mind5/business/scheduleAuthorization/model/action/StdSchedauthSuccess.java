package br.com.mind5.business.scheduleAuthorization.model.action;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedauthSuccess extends ActionStdSuccessTemplate<SchedauthInfo> {
	
	public StdSchedauthSuccess(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
}
