package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckLangu extends ModelCheckerTemplateForward<RefemInfo, LanguInfo> {
	
	public RefemCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(RefemInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
