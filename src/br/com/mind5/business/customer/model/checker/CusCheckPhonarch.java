package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CusCheckPhonarch extends ModelCheckerTemplateForwardV2<CusInfo, PhonarchInfo> {
	
	public CusCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExist(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(CusInfo baseRecord) {
		return PhonarchCopier.copyFromCusKey(baseRecord);
	}
}
