package br.com.mind5.form.formAddressSearch.model.action;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormesarchDaoSelect extends ActionStdTemplateV2<FormesarchInfo> {

	public StdFormesarchDaoSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FormesarchInfo> buildVisitorHook(DeciTreeOption<FormesarchInfo> option) {
		return new VisiFormesarchDaoSelect(option);
	}
}
