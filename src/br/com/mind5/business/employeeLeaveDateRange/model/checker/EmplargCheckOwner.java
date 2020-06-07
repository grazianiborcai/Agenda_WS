package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmplargCheckOwner extends ModelCheckerTemplateForwardV2<EmplargInfo, OwnerInfo> {
	
	public EmplargCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmplargInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
