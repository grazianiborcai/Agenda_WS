package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatCheckOwner extends ModelCheckerTemplateForwardV2<MatInfo, OwnerInfo> {
	
	public MatCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
