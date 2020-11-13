package br.com.mind5.business.orderItemSearch.model.checker;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdemarchCheckOwner extends ModelCheckerTemplateForward<OrdemarchInfo, OwnerInfo> {
	
	public OrdemarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdemarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
