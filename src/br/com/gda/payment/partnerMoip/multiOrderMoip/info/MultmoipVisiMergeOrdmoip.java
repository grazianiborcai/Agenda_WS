package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipVisiMergeOrdmoip implements InfoMergerVisitorV2<MultmoipInfo, OrdmoipInfo> {

	@Override public MultmoipInfo writeRecord(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MultmoipInfo merge(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		if(sourceTwo.ordmoips.contains(sourceOne)) 
			removeElement(sourceOne, sourceTwo);		
		
		sourceTwo.ordmoips.add(makeClone(sourceOne));
		return sourceTwo;
	}
	
	
	
	private MultmoipInfo removeElement(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		int idx = sourceTwo.ordmoips.indexOf(sourceOne);
		sourceTwo.ordmoips.remove(idx);
		
		return sourceTwo;
	}
	
	
	
	private OrdmoipInfo makeClone(OrdmoipInfo recordInfo) {
		try {
			return (OrdmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
