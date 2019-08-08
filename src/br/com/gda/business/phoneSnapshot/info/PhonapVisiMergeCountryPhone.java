package br.com.gda.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhonapVisiMergeCountryPhone implements InfoMergerVisitor<PhonapInfo, CountryPhoneInfo> {

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}



	@Override public boolean shouldWrite(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		return (sourceOne.codCountryPhone == sourceTwo.codCountryPhone);
	}
}
