package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapVisiMergeCountryPhone implements InfoMergerVisitor_<PhonapInfo, CountryPhoneInfo> {

	@Override public PhonapInfo writeRecord(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhonapInfo merge(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		PhonapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCountry = sourceOne.codCountry;		
		
		return resultInfo;
	}
	
	
	
	private PhonapInfo makeClone(PhonapInfo recordInfo) {
		try {
			return (PhonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}



	@Override public boolean shouldWrite(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		return (sourceOne.codCountryPhone == sourceTwo.codCountryPhone);
	}
}
