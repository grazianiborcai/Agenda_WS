package br.com.mind5.security.userList.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StdUselisSuccess extends ActionStdSuccessTemplate<UselisInfo> {
	public StdUselisSuccess(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
}
