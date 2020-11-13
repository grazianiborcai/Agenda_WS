package br.com.mind5.message.emailScheduleConfirmation.model.action;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmulonEnforceEmabody extends ActionStdTemplate<EmulonInfo> {

	public StdEmulonEnforceEmabody(DeciTreeOption<EmulonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmulonInfo> buildVisitorHook(DeciTreeOption<EmulonInfo> option) {
		return new VisiEmulonEnforceEmabody(option);
	}
}
