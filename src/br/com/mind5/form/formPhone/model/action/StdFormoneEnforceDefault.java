package br.com.mind5.form.formPhone.model.action;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormoneEnforceDefault extends ActionStdTemplateV2<FormoneInfo> {

	public StdFormoneEnforceDefault(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FormoneInfo> buildVisitorHook(DeciTreeOption<FormoneInfo> option) {
		return new VisiFormoneEnforceDefault(option);
	}
}
