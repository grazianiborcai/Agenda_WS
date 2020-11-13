package br.com.mind5.form.formAddress.model.action;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormessMergeFormesarch extends ActionStdTemplate<FormessInfo> {

	public StdFormessMergeFormesarch(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FormessInfo> buildVisitorHook(DeciTreeOption<FormessInfo> option) {
		return new VisiFormessMergeFormesarch(option);
	}
}
