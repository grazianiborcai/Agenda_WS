package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapSuccess extends ActionStdSuccessTemplate<UserapInfo> {
	public StdUserapSuccess(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
}
