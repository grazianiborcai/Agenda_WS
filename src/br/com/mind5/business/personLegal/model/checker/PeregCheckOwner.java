package br.com.mind5.business.personLegal.model.checker;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PeregCheckOwner extends ModelCheckerTemplateForward<PeregInfo, OwnerInfo> {
	
	public PeregCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PeregInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
