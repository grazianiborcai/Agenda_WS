package br.com.gda.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CusVisitorPhone implements InfoMergerVisitor<CusInfo, PhoneInfo, CusInfo> {

	@Override public CusInfo writeRecord(PhoneInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, CusInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner) {
			logException(new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH));
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
		
		if (sourceOne.codCustomer != sourceTwo.codCustomer) {
			logException(new IllegalArgumentException("codCustomer" + SystemMessage.ARGUMENT_DONT_MATCH));
			throw new IllegalArgumentException("codCustomer" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(PhoneInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
