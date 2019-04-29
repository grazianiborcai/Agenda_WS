package br.com.gda.payService.payPartnerCountry.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PayparCountryVisitorPaypar implements InfoMergerVisitor_<PayparCountryInfo, PayparInfo, PayparCountryInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public PayparCountryInfo writeRecord(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayparCountryInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.txtPayPartner = sourceOne.txtPayPartner; 
		clonedInfo.description = sourceOne.description;
		return clonedInfo;
	}
	
	
	
	private PayparCountryInfo makeClone(PayparCountryInfo recordInfo) {
		try {
			return (PayparCountryInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		if (sourceOne.codPayPartner	== sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
