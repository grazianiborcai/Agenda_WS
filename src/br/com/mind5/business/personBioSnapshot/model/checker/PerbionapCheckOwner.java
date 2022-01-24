package br.com.mind5.business.personBioSnapshot.model.checker;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PerbionapCheckOwner extends ModelCheckerTemplateForward<PerbionapInfo, OwnerInfo> {
	
	public PerbionapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PerbionapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
