package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PayCusVisiAddress implements InfoMergerVisitor<PayCusInfo, AddressInfo, PayCusInfo> {

	@Override public PayCusInfo writeRecord(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayCusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayCusInfo makeClone(PayCusInfo recordInfo) {
		try {
			return (PayCusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PayCusInfo merge(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		sourceTwo.address = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codPayCustomer == sourceTwo.codPayCustomer);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
