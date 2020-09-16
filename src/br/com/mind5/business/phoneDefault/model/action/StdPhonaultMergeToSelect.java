package br.com.mind5.business.phoneDefault.model.action;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonaultMergeToSelect extends ActionStdTemplateV2<PhonaultInfo> {

	public StdPhonaultMergeToSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PhonaultInfo> buildVisitorHook(DeciTreeOption<PhonaultInfo> option) {
		return new VisiPhonaultMergeToSelect(option);
	}
}