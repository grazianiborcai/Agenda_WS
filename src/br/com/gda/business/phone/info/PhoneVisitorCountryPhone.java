package br.com.gda.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhoneVisitorCountryPhone implements InfoMergerVisitor<PhoneInfo, CountryPhoneInfo, PhoneInfo> {

	@Override public PhoneInfo writeRecord(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		if (sourceOne.codCountry.equals(sourceTwo.codCountry) == false) {
			logException(new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH));
			throw new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private PhoneInfo merge(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		PhoneInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCountryPhone = sourceOne.codCountryPhone;
		
		return resultInfo;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
