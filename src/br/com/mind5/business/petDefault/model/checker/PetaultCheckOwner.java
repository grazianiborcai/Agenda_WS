package br.com.mind5.business.petDefault.model.checker;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PetaultCheckOwner extends ModelCheckerTemplateForward<PetaultInfo, OwnerInfo> {
	
	public PetaultCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PetaultInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
