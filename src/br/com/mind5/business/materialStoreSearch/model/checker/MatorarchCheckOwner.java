package br.com.mind5.business.materialStoreSearch.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatorarchCheckOwner extends ModelCheckerTemplateForwardV2<MatorarchInfo, OwnerInfo> {
	
	public MatorarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatorarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
