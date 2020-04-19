package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgRestoreBase extends ActionStdTemplateV2<SymsgInfo> {

	public StdSymsgRestoreBase(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SymsgInfo> buildVisitorHook(DeciTreeOption<SymsgInfo> option) {
		return new VisiSymsgRestoreBase(option);
	}
}
