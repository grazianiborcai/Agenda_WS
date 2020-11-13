package br.com.mind5.business.materialList.model.checker;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatlisCheckOwner extends ModelCheckerTemplateForward<MatlisInfo, OwnerInfo> {
	
	public MatlisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatlisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
