package br.com.mind5.business.employeeSearch.model.checker;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmparchCheckOwner extends ModelCheckerTemplateForward<EmparchInfo, OwnerInfo> {
	
	public EmparchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmparchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
