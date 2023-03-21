package br.com.mind5.business.orderStatusChange.model.checker;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;

public final class OrdugeCheckPayord extends ModelCheckerTemplateForward<OrdugeInfo, PayordInfo> {
	
	public OrdugeCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(OrdugeInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
