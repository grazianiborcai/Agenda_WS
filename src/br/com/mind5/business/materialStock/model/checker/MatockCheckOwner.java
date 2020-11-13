package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatockCheckOwner extends ModelCheckerTemplateForwardV2<MatockInfo, OwnerInfo> {
	
	public MatockCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatockInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
