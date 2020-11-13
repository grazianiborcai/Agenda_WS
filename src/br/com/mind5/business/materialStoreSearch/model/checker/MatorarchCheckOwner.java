package br.com.mind5.business.materialStoreSearch.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatorarchCheckOwner extends ModelCheckerTemplateForward<MatorarchInfo, OwnerInfo> {
	
	public MatorarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatorarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
