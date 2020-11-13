package br.com.mind5.security.userList.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StdUselisDaoSelect extends ActionStdTemplate<UselisInfo> {

	public StdUselisDaoSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UselisInfo> buildVisitorHook(DeciTreeOption<UselisInfo> option) {
		return new VisiUselisDaoSelect(option);
	}
}
