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
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(EmpInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codEmployee == sourceTwo.codEmployee);
	}
}
