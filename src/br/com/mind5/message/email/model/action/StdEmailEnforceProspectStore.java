package br.com.mind5.message.email.model.action;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmailEnforceProspectStore extends ActionStdTemplate<EmailInfo> {

	public StdEmailEnforceProspectStore(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmailInfo> buildVisitorHook(DeciTreeOption<EmailInfo> option) {
		return new VisiEmailEnforceProspectStore(option);
	}
}
