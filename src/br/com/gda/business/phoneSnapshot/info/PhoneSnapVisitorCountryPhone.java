package br.com.gda.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PhoneSnapVisitorCountryPhone implements InfoMergerVisitor_<PhoneSnapInfo, CountryPhoneInfo, PhoneSnapInfo> {

	@Override public PhoneSnapInfo writeRecord(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneSnapInfo merge(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		PhoneSnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCountry = sourceOne.codCountry;		
		
		return resultInfo;
	}
	
	
	
	private PhoneSnapInfo makeClone(PhoneSnapInfo recordInfo) {
		try {
			return (PhoneSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}



	@Override public boolean shouldWrite(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return (sourceOne.codCountryPhone == sourceTwo.codCountryPhone);
	}
}
