package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.checker.EntityCategCheckExist;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PersonCheckEntityCateg extends ModelCheckerTemplateForwardV2<PersonInfo, EntityCategInfo> {
	
	public PersonCheckEntityCateg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EntityCategInfo> getCheckerHook(ModelCheckerOption option) {
		return new EntityCategCheckExist(option);
	}
	
	
	
	@Override protected EntityCategInfo toForwardClass(PersonInfo baseRecord) {
		return EntityCategInfo.copyFrom(baseRecord);
	}
}
