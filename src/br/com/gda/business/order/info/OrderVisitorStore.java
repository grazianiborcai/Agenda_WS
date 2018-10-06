package br.com.gda.business.order.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisitorStore implements InfoMergerVisitor<OrderInfo, StoreInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(StoreInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.storeCnpj = sourceOne.cnpj;
		resultInfo.storeInscrMun = sourceOne.inscrMun;
		
		resultInfo.storeInscrEst = sourceOne.inscrEst;
		resultInfo.storeName = sourceOne.name;
		resultInfo.storeCountry = sourceOne.codCountry;
		resultInfo.storeStateProvince = sourceOne.stateProvince;
		resultInfo.storeCodCurr = sourceOne.codCurr;
		resultInfo.storeCodTimezone = sourceOne.codTimezone;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, OrderInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
