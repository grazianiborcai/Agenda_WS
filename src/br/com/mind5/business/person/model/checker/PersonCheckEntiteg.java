package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PersonCheckEntiteg extends ModelCheckerTemplateForwardV2<PersonInfo, EntitegInfo> {
	
	public PersonCheckEntiteg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EntitegInfo> getCheckerHook(ModelCheckerOption option) {
		return new EntitegCheckExist(option);
	}
	
	
	
	@Override protected EntitegInfo toForwardClass(PersonInfo baseRecord) {
		return EntitegInfo.copyFrom(baseRecord);
	}
}
