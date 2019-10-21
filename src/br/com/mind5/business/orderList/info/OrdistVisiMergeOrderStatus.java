package br.com.mind5.business.orderList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdistVisiMergeOrderStatus implements InfoMergerVisitor<OrdistInfo, OrderStatusInfo> {

	@Override public OrdistInfo writeRecord(OrderStatusInfo sourceOne, OrdistInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdistInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrderStatusInfo sourceOne, OrdistInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdistInfo makeClone(OrdistInfo recordInfo) {
		try {
			return (OrdistInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrdistInfo merge(OrderStatusInfo sourceOne, OrdistInfo sourceTwo) {
		sourceTwo.txtOrderStatus = sourceOne.txtOrderStatus;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderStatusInfo sourceOne, OrdistInfo sourceTwo) {		
		return (sourceOne.codOrderStatus.equals(sourceTwo.codOrderStatus));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
