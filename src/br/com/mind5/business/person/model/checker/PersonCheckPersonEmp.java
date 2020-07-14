package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckPersonEmp;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PersonCheckPersonEmp extends ModelCheckerTemplateForwardV2<PersonInfo, PerarchInfo> {
	
	public PersonCheckPersonEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PerarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PerarchCheckPersonEmp(option);
	}
	
	
	
	@Override protected PerarchInfo toForwardClass(PersonInfo baseRecord) {
		return PerarchInfo.copyFrom(baseRecord);
	}
}
