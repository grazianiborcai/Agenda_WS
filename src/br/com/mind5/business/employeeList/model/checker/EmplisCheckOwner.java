package br.com.mind5.business.employeeList.model.checker;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmplisCheckOwner extends ModelCheckerTemplateForwardV2<EmplisInfo, OwnerInfo> {
	
	public EmplisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmplisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
