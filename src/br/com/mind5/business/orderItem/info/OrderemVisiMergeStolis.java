package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemVisiMergeStolis implements InfoMergerVisitor_<OrderemInfo, StolisInfo> {

	@Override public OrderemInfo writeRecord(StolisInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.stolisData = sourceOne;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.txtCurr = sourceOne.txtCurr;
		return resultInfo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, OrderemInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, OrderemInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codStore == sourceTwo.codStore	);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
