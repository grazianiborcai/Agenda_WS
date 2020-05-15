package br.com.mind5.security.userList.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StdUselisDaoSelect extends ActionStdTemplateV2<UselisInfo> {

	public StdUselisDaoSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UselisInfo> buildVisitorHook(DeciTreeOption<UselisInfo> option) {
		return new VisiUselisDaoSelect(option);
	}
}
