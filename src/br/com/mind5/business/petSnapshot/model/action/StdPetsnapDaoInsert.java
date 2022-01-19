package br.com.mind5.business.petSnapshot.model.action;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetsnapDaoInsert extends ActionStdTemplate<PetsnapInfo> {

	public StdPetsnapDaoInsert(DeciTreeOption<PetsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetsnapInfo> buildVisitorHook(DeciTreeOption<PetsnapInfo> option) {
		return new VisiPetsnapDaoInsert(option);
	}
}
