package br.com.gda.business.order.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisitorMat implements InfoMergerVisitor<OrderInfo, MatInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(MatInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matUnit = sourceOne.codUnit;
		resultInfo.matCodType = sourceOne.codType;
		resultInfo.matCodCategory = sourceOne.codCategory;
		resultInfo.matPriceUnit = sourceOne.priceUnit;
		resultInfo.matCodGroup = sourceOne.codGroup;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, OrderInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codMat != sourceTwo.codMat)
			throw new IllegalArgumentException("codMat" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
