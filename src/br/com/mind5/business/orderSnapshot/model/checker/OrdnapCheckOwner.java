package br.com.mind5.business.orderSnapshot.model.checker;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdnapCheckOwner extends ModelCheckerTemplateForward<OrdnapInfo, OwnerInfo> {
	
	public OrdnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
