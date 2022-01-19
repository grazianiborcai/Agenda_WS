package br.com.mind5.business.petSearch.model.checker;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class PetarchCheckUsername extends ModelCheckerTemplateForward<PetarchInfo, UsernameInfo> {
	
	public PetarchCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(PetarchInfo baseRecord) {
		return UsernameCopier.copyFromPetarch(baseRecord);
	}
}
