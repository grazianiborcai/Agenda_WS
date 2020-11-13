package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckPersonCus;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersonCheckPersonCus extends ModelCheckerTemplateForward<PersonInfo, PerarchInfo> {
	
	public PersonCheckPersonCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PerarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PerarchCheckPersonCus(option);
	}
	
	
	
	@Override protected PerarchInfo toForwardClass(PersonInfo baseRecord) {
		return PerarchInfo.copyFrom(baseRecord);
	}
}
