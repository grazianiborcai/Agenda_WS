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
		//TODO: persitir endereco/telefone

		return resultInfo;
	}
	
	
	
	private void checkArgument(CusInfo sourceOne, OrderInfo sourceTwo) {
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



	@Override public boolean shouldWrite(CusInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codCustomer == sourceTwo.codCustomer);
	}
}
