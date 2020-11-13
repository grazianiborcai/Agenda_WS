package br.com.mind5.business.materialSearch.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatarchCheckOwner extends ModelCheckerTemplateForward<MatarchInfo, OwnerInfo> {
	
	public MatarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
