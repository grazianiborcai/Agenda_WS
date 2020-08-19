package br.com.mind5.business.materialGroupStore.model.checker;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatoporeCheckOwner extends ModelCheckerTemplateForwardV2<MatoporeInfo, OwnerInfo> {
	
	public MatoporeCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatoporeInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
