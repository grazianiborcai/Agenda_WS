package br.com.mind5.business.personRestricted.model.action;

import br.com.mind5.business.personRestricted.info.PersoresInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersoresMergePersolis extends ActionStdTemplate<PersoresInfo> {

	public StdPersoresMergePersolis(DeciTreeOption<PersoresInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PersoresInfo> buildVisitorHook(DeciTreeOption<PersoresInfo> option) {
		return new VisiPersoresMergePersolis(option);
	}
}
