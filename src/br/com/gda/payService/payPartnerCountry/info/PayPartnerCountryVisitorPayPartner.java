package br.com.gda.payService.payPartnerCountry.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PayPartnerCountryVisitorPayPartner implements InfoMergerVisitor<PayPartnerCountryInfo, PayPartnerInfo, PayPartnerCountryInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public PayPartnerCountryInfo writeRecord(PayPartnerInfo sourceOne, PayPartnerCountryInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayPartnerCountryInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.txtPayPartner = sourceOne.txtPayPartner; 
		clonedInfo.description = sourceOne.description;
		return clonedInfo;
	}
	
	
	
	private PayPartnerCountryInfo makeClone(PayPartnerCountryInfo recordInfo) {
		try {
			return (PayPartnerCountryInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(PayPartnerInfo sourceOne, PayPartnerCountryInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayPartnerInfo sourceOne, PayPartnerCountryInfo sourceTwo) {
		if (sourceOne.codPayPartner	== sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
