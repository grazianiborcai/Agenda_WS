package br.com.mind5.business.phone.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhoneVisiMergeCountryPhone implements InfoMergerVisitor_<PhoneInfo, CountryPhoneInfo> {

	@Override public PhoneInfo writeRecord(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneInfo merge(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		PhoneInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCountry = sourceOne.codCountry;		
		
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
		
		SystemLog.logError(this.getClass(), e);
	}



	@Override public boolean shouldWrite(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return (sourceOne.codCountryPhone == sourceTwo.codCountryPhone);
	}
}
