package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckPerson extends ModelCheckerTemplateForward<StoreInfo, PersonInfo> {
	
	public StoreCheckPerson(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PersonInfo> getCheckerHook(ModelCheckerOption option) {
		return new PersonCheckExist(option);
	}
	
	
	
	@Override protected PersonInfo toForwardClass(StoreInfo baseRecord) {
		return PersonInfo.copyFrom(baseRecord);
	}
}
