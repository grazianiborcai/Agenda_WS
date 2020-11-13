package br.com.mind5.message.emailScheduleCancellation.model.action;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmulelMergeCuslis extends ActionStdTemplate<EmulelInfo> {

	public StdEmulelMergeCuslis(DeciTreeOption<EmulelInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmulelInfo> buildVisitorHook(DeciTreeOption<EmulelInfo> option) {
		return new VisiEmulelMergeCuslis(option);
	}
}
