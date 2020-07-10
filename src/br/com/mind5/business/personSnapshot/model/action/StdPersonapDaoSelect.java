package br.com.mind5.business.personSnapshot.model.action;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonapDaoSelect extends ActionStdTemplateV2<PersonapInfo> {

	public StdPersonapDaoSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PersonapInfo> buildVisitorHook(DeciTreeOption<PersonapInfo> option) {
		return new VisiPersonapDaoSelect(option);
	}
}
