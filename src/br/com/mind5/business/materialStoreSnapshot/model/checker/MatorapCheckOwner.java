package br.com.mind5.business.materialStoreSnapshot.model.checker;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatorapCheckOwner extends ModelCheckerTemplateForward<MatorapInfo, OwnerInfo> {
	
	public MatorapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatorapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
