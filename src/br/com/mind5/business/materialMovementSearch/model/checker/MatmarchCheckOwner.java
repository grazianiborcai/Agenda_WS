package br.com.mind5.business.materialMovementSearch.model.checker;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmarchCheckOwner extends ModelCheckerTemplateForward<MatmarchInfo, OwnerInfo> {
	
	public MatmarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatmarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
