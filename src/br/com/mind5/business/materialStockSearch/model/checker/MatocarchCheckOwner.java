package br.com.mind5.business.materialStockSearch.model.checker;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatocarchCheckOwner extends ModelCheckerTemplateForwardV2<MatocarchInfo, OwnerInfo> {
	
	public MatocarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatocarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
