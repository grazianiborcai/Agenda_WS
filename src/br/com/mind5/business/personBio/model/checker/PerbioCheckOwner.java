package br.com.mind5.business.personBio.model.checker;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PerbioCheckOwner extends ModelCheckerTemplateForward<PerbioInfo, OwnerInfo> {
	
	public PerbioCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PerbioInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
