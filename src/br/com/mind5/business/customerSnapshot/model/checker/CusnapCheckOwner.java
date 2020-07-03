package br.com.mind5.business.customerSnapshot.model.checker;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CusnapCheckOwner extends ModelCheckerTemplateForwardV2<CusnapInfo, OwnerInfo> {
	
	public CusnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CusnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
