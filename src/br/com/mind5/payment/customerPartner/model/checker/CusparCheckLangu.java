package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckLangu extends ModelCheckerTemplateForward<CusparInfo, LanguInfo> {
	
	public CusparCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CusparInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
