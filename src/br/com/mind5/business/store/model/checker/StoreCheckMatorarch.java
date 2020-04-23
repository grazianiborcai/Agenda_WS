package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchCopier;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckMatorarch extends ModelCheckerTemplateForwardV2<StoreInfo, MatorarchInfo> {
	
	public StoreCheckMatorarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatorarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatorarchCheckExist(option);
	}
	
	
	
	@Override protected MatorarchInfo toForwardClass(StoreInfo baseRecord) {
		return MatorarchCopier.copyFromStore(baseRecord);
	}
}
