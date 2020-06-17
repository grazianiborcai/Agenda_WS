package br.com.mind5.message.emailPasswordChange.model.action;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmordeSendEmail extends ActionStdTemplateV2<EmordeInfo> {

	public StdEmordeSendEmail(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmordeInfo> buildVisitorHook(DeciTreeOption<EmordeInfo> option) {
		return new VisiEmordeSendEmail(option);
	}
}
