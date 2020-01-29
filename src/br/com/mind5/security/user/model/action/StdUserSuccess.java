package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserSuccess extends ActionStdSuccessTemplate<UserInfo> {
	public StdUserSuccess(DeciTreeOption<UserInfo> option) {
		super(option);
	}
}
