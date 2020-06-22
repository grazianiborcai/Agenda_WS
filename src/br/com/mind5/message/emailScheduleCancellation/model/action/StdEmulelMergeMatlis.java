package br.com.mind5.message.emailScheduleCancellation.model.action;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmulelMergeMatlis extends ActionStdTemplateV2<EmulelInfo> {

	public StdEmulelMergeMatlis(DeciTreeOption<EmulelInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmulelInfo> buildVisitorHook(DeciTreeOption<EmulelInfo> option) {
		return new VisiEmulelMergeMatlis(option);
	}
}
