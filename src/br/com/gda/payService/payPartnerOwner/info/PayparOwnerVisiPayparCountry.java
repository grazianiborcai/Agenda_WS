package br.com.gda.payService.payPartnerOwner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

final class PayparOwnerVisiPayparCountry implements InfoMergerVisitor<PayparOwnerInfo, PayparCountryInfo, PayparOwnerInfo> {

	@Override public PayparOwnerInfo writeRecord(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayparOwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayparOwnerInfo makeClone(PayparOwnerInfo recordInfo) {
		try {
			return (PayparOwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PayparOwnerInfo merge(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.txtPayPartner = sourceOne.txtPayPartner;
		sourceTwo.description = sourceOne.description;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return (sourceOne.codCountry != null && 
				sourceTwo.codCountry != null &&
				sourceTwo.codCountry.equals(sourceOne.codCountry)	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
