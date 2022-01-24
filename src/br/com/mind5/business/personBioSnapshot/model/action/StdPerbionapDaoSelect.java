package br.com.mind5.business.personBioSnapshot.model.action;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbionapDaoSelect extends ActionStdTemplate<PerbionapInfo> {

	public StdPerbionapDaoSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbionapInfo> buildVisitorHook(DeciTreeOption<PerbionapInfo> option) {
		return new VisiPerbionapDaoSelect(option);
	}
}
