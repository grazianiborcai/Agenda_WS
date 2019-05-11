package br.com.gda.payService.payPartnerOwner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PayparOwnerVisiOwner implements InfoMergerVisitor_<PayparOwnerInfo, OwnerInfo, PayparOwnerInfo> {

	@Override public PayparOwnerInfo writeRecord(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayparOwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
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
	
	
	
	private PayparOwnerInfo merge(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codCountry = sourceOne.companyData.codCountryLegal;
		sourceTwo.txtCountry = sourceOne.companyData.txtCountryLegal;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return (sourceOne != null && sourceOne.companyData != null );
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
