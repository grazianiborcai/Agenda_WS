package br.com.mind5.business.materialSnapshot.model.checker;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatsnapCheckOwner extends ModelCheckerTemplateForward<MatsnapInfo, OwnerInfo> {
	
	public MatsnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatsnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
