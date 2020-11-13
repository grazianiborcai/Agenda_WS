package br.com.mind5.business.person.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersonCheckSytotauh extends ModelCheckerTemplateForward<PersonInfo, SytotauhInfo> {
	
	public PersonCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(PersonInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
