package br.com.mind5.business.companyList.model.checker;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class ComplisCheckOwner extends ModelCheckerTemplateForward<ComplisInfo, OwnerInfo> {
	
	public ComplisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(ComplisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
