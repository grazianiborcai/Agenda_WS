package br.com.mind5.message.emailWelcome.model.action;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmacomeEnforceEmabody extends ActionStdTemplateV2<EmacomeInfo> {

	public StdEmacomeEnforceEmabody(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmacomeInfo> buildVisitorHook(DeciTreeOption<EmacomeInfo> option) {
		return new VisiEmacomeEnforceEmabody(option);
	}
}
