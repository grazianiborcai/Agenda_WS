package br.com.mind5.business.form.formAddress.model.action;

import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormessDaoSelect extends ActionStdTemplateV2<FormessInfo> {

	public StdFormessDaoSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FormessInfo> buildVisitorHook(DeciTreeOption<FormessInfo> option) {
		return new VisiFormessDaoSelect(option);
	}
}
