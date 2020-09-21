package br.com.mind5.business.storeTextDefault.model.checker;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StorextaultCheckOwner extends ModelCheckerTemplateForwardV2<StorextaultInfo, OwnerInfo> {
	
	public StorextaultCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StorextaultInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
