package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatoreCheckOwner extends ModelCheckerTemplateForward<MatoreInfo, OwnerInfo> {
	
	public MatoreCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatoreInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
