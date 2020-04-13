package br.com.mind5.form.formAddress.model.action;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormessMergeFormesarch extends ActionStdTemplateV2<FormessInfo> {

	public StdFormessMergeFormesarch(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FormessInfo> buildVisitorHook(DeciTreeOption<FormessInfo> option) {
		return new VisiFormessMergeFormesarch(option);
	}
}
