package br.com.mind5.business.phoneDefault.model.checker;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PhonaultCheckOwner extends ModelCheckerTemplateForwardV2<PhonaultInfo, OwnerInfo> {
	
	public PhonaultCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PhonaultInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}