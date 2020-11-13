package br.com.mind5.business.employeeWorkTimeOutlier.model.checker;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpwoutCheckOwner extends ModelCheckerTemplateForward<EmpwoutInfo, OwnerInfo> {
	
	public EmpwoutCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmpwoutInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
