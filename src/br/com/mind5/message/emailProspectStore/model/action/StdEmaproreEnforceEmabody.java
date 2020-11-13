package br.com.mind5.message.emailProspectStore.model.action;

import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmaproreEnforceEmabody extends ActionStdTemplate<EmaproreInfo> {

	public StdEmaproreEnforceEmabody(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmaproreInfo> buildVisitorHook(DeciTreeOption<EmaproreInfo> option) {
		return new VisiEmaproreEnforceEmabody(option);
	}
}
