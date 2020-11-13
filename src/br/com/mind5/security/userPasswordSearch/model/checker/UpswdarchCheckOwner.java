package br.com.mind5.security.userPasswordSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class UpswdarchCheckOwner extends ModelCheckerTemplateForward<UpswdarchInfo, OwnerInfo> {
	
	public UpswdarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(UpswdarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
