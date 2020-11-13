package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderemCheckEmpmat extends ModelCheckerTemplateForward<OrderemInfo, EmpmatInfo> {
	
	public OrderemCheckEmpmat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpmatInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmatCheckExist(option);
	}
	
	
	
	@Override protected EmpmatInfo toForwardClass(OrderemInfo baseRecord) {
		return EmpmatInfo.copyFrom(baseRecord);
	}
}
