package br.com.mind5.business.phoneSearch.model.action;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonarchMergeToSelect extends ActionStdTemplateV2<PhonarchInfo> {

	public StdPhonarchMergeToSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PhonarchInfo> buildVisitorHook(DeciTreeOption<PhonarchInfo> option) {
		return new VisiPhonarchMergeToSelect(option);
	}
}
