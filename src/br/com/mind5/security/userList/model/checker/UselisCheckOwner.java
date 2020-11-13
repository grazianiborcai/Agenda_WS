package br.com.mind5.security.userList.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckOwner extends ModelCheckerTemplateForward<UselisInfo, OwnerInfo> {
	
	public UselisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(UselisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
