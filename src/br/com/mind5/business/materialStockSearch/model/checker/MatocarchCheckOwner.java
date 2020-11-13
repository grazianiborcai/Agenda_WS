package br.com.mind5.business.materialStockSearch.model.checker;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatocarchCheckOwner extends ModelCheckerTemplateForward<MatocarchInfo, OwnerInfo> {
	
	public MatocarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatocarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
