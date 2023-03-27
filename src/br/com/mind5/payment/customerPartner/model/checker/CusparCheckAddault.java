package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckExistUser;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddault extends ModelCheckerTemplateForward<CusparInfo, AddaultInfo> {
	
	public CusparCheckAddault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddaultCheckExistUser(option);
	}
	
	
	
	@Override protected AddaultInfo toForwardClass(CusparInfo baseRecord) {
		return AddaultInfo.copyFrom(baseRecord);
	}
}
