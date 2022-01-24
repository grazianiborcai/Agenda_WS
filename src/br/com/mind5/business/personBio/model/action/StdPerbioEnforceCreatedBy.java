package br.com.mind5.business.personBio.model.action;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbioEnforceCreatedBy extends ActionStdTemplate<PerbioInfo> {

	public StdPerbioEnforceCreatedBy(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbioInfo> buildVisitorHook(DeciTreeOption<PerbioInfo> option) {
		return new VisiPerbioEnforceCreatedBy(option);
	}
}
