package br.com.mind5.security.userList.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckOwner extends ModelCheckerTemplateForwardV2<UselisInfo, OwnerInfo> {
	
	public UselisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(UselisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
