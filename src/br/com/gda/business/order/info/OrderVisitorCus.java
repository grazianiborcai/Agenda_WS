package br.com.gda.business.order.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisitorCus implements InfoMergerVisitor<OrderInfo, CusInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(CusInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.cusCpf = sourceOne.cpf;
		resultInfo.cusEmail = sourceOne.email;
		resultInfo.cusName = sourceOne.name;
		//resultInfo.cusCodCountry = sourceOne.codCountry1;
		//resultInfo.cusCodState = sourceOne.codState1;
		//TODO: persitir endereco

		return resultInfo;
	}
	
	
	
	private void checkArgument(CusInfo sourceOne, OrderInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codCustomer != sourceTwo.codCustomer)
			throw new IllegalArgumentException("codCustomer" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
