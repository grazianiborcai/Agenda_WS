package br.com.mind5.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class PayordVisiMergeLatest implements InfoMergerVisitor<PayordInfo, PayordarchInfo> {

	@Override public PayordInfo writeRecord(PayordarchInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PayordarchInfo sourceOne, PayordInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayordInfo merge(PayordarchInfo sourceOne, PayordInfo sourceTwo) {
		PayordInfo result = makeClone(sourceTwo);		
		result.latestData = sourceOne;
		return result;
	}
	
	
	
	private PayordInfo makeClone(PayordInfo recordInfo) {
		try {
			return (PayordInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PayordarchInfo sourceOne, PayordInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
