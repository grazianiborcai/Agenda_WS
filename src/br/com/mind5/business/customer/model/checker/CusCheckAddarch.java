package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExist;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CusCheckAddarch extends ModelCheckerTemplateForward<CusInfo, AddarchInfo> {
	
	public CusCheckAddarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddarchCheckExist(option);
	}
	
	
	
	@Override protected AddarchInfo toForwardClass(CusInfo baseRecord) {
		return AddarchCopier.copyFromCusKey(baseRecord);
	}
}
