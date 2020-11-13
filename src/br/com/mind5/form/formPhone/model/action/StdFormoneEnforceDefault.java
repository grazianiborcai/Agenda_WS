package br.com.mind5.form.formPhone.model.action;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormoneEnforceDefault extends ActionStdTemplate<FormoneInfo> {

	public StdFormoneEnforceDefault(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FormoneInfo> buildVisitorHook(DeciTreeOption<FormoneInfo> option) {
		return new VisiFormoneEnforceDefault(option);
	}
}
