package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpwocoCheckOwner extends ModelCheckerTemplateForward<EmpwocoInfo, OwnerInfo> {
	
	public EmpwocoCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmpwocoInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
