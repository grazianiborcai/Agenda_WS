package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgDaoSelect extends ActionStdTemplate<SymsgInfo> {

	public StdSymsgDaoSelect(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SymsgInfo> buildVisitorHook(DeciTreeOption<SymsgInfo> option) {
		return new VisiSymsgDaoSelect(option);
	}
}
