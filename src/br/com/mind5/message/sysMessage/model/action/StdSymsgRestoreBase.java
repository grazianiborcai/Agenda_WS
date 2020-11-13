package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgRestoreBase extends ActionStdTemplate<SymsgInfo> {

	public StdSymsgRestoreBase(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SymsgInfo> buildVisitorHook(DeciTreeOption<SymsgInfo> option) {
		return new VisiSymsgRestoreBase(option);
	}
}
