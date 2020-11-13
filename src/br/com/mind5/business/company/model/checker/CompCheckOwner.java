package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompCheckOwner extends ModelCheckerTemplateForward<CompInfo, OwnerInfo> {
	
	public CompCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CompInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
