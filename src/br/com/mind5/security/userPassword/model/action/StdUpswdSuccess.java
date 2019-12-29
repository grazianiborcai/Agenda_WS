package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdSuccess extends ActionStdSuccessTemplate<UpswdInfo> {
	
	public StdUpswdSuccess(DeciTreeOption<UpswdInfo> option) {
		super(UpswdInfo.class);
	}
}
