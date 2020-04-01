package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemVisiMergeOrdemrap implements InfoMergerVisitor_<OrderemInfo, OrdemrapInfo> {

	@Override public OrderemInfo writeRecord(OrdemrapInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrdemrapInfo sourceOne, OrderemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderemInfo makeClone(OrderemInfo recordInfo) {
		try {
			return (OrderemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrderemInfo merge(OrdemrapInfo sourceOne, OrderemInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrdemrapInfo sourceOne, OrderemInfo sourceTwo) {		
		return (sourceOne.codOwner 		== sourceTwo.codOwner &&
				sourceOne.codOrder 		== sourceTwo.codOrder &&
				sourceOne.codOrderItem 	== sourceTwo.codOrderItem); 
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
