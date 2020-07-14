package br.com.mind5.business.employeeSnapshot.model.checker;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpnapCheckOwner extends ModelCheckerTemplateForwardV2<EmpnapInfo, OwnerInfo> {
	
	public EmpnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmpnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
