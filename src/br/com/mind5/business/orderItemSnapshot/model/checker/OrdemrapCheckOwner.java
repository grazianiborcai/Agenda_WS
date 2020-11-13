package br.com.mind5.business.orderItemSnapshot.model.checker;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdemrapCheckOwner extends ModelCheckerTemplateForward<OrdemrapInfo, OwnerInfo> {
	
	public OrdemrapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdemrapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
