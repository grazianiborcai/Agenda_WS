package br.com.gda.business.order.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisitorEmp implements InfoMergerVisitor<OrderInfo, EmpInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(EmpInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.empCpf = sourceOne.cpf;
		resultInfo.empName = sourceOne.name;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, OrderInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codEmployee != sourceTwo.codEmployee)
			throw new IllegalArgumentException("codEmployee" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
