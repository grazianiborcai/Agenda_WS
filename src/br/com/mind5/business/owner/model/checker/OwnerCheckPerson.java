package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OwnerCheckPerson extends ModelCheckerTemplateForwardV2<OwnerInfo, PersonInfo> {
	
	public OwnerCheckPerson(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PersonInfo> getCheckerHook(ModelCheckerOption option) {
		return new PersonCheckExist(option);
	}
	
	
	
	@Override protected PersonInfo toForwardClass(OwnerInfo baseRecord) {
		return PersonInfo.copyFrom(baseRecord);
	}
}
