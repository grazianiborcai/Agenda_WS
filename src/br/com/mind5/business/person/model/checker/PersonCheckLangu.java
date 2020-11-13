package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersonCheckLangu extends ModelCheckerTemplateForward<PersonInfo, LanguInfo> {
	
	public PersonCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PersonInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
