package br.com.mind5.business.personSnapshot.model.action;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPersonapMergeGender extends ActionStdTemplate<PersonapInfo> {

	public StdPersonapMergeGender(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PersonapInfo> buildVisitorHook(DeciTreeOption<PersonapInfo> option) {
		return new VisiPersonapMergeGender(option);
	}
}
