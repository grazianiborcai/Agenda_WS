package br.com.mind5.form.formAddressSearch.model.action;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormesarchMergeToSelect extends ActionStdTemplate<FormesarchInfo> {
	
	public StdFormesarchMergeToSelect(DeciTreeOption<FormesarchInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<FormesarchInfo> buildVisitorHook(DeciTreeOption<FormesarchInfo> option) {
		return new VisiFormesarchMergeToSelect(option);
	}
}
