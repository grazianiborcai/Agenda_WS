package br.com.mind5.config.sysStoreBusinessContent.model.action;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytorbcEnforceEnabled extends ActionStdTemplate<SytorbcInfo> {

	public StdSytorbcEnforceEnabled(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SytorbcInfo> buildVisitorHook(DeciTreeOption<SytorbcInfo> option) {
		return new VisiSytorbcEnforceEnabled(option);
	}
}
