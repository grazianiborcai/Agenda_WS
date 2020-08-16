package br.com.mind5.business.materialStoreSnapshot.model.checker;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatorapCheckOwner extends ModelCheckerTemplateForwardV2<MatorapInfo, OwnerInfo> {
	
	public MatorapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatorapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
