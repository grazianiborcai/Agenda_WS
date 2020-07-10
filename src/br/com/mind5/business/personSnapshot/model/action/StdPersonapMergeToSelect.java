package br.com.mind5.business.personSnapshot.model.action;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonapMergeToSelect extends ActionStdTemplateV2<PersonapInfo> {

	public StdPersonapMergeToSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PersonapInfo> buildVisitorHook(DeciTreeOption<PersonapInfo> option) {
		return new VisiPersonapMergeToSelect(option);
	}
}
