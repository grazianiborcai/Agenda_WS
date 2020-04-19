package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgSuccess extends ActionStdSuccessTemplate<SymsgInfo> {
	public StdSymsgSuccess(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
}
