package br.com.mind5.business.storeTextSearch.model.checker;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StorextarchCheckOwner extends ModelCheckerTemplateForwardV2<StorextarchInfo, OwnerInfo> {
	
	public StorextarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StorextarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
