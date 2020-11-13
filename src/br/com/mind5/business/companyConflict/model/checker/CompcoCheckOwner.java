package br.com.mind5.business.companyConflict.model.checker;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompcoCheckOwner extends ModelCheckerTemplateForward<CompcoInfo, OwnerInfo> {
	
	public CompcoCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CompcoInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
