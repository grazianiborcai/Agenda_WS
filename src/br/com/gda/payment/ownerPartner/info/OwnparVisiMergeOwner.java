package br.com.gda.payment.ownerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OwnparVisiMergeOwner implements InfoMergerVisitor<OwnparInfo, OwnerInfo> {

	@Override public OwnparInfo writeRecord(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnparInfo makeClone(OwnparInfo recordInfo) {
		try {
			return (OwnparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnparInfo merge(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codCountry = sourceOne.companyData.codCountryLegal;
		sourceTwo.txtCountry = sourceOne.companyData.txtCountryLegal;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		return (sourceOne != null && sourceOne.companyData != null );
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
