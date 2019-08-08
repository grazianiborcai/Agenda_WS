package br.com.gda.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class AddresnapVisiMergeCountry implements InfoMergerVisitor<AddresnapInfo, CountryInfo> {

	@Override public AddresnapInfo writeRecord(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo merge(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		AddresnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtCountry = sourceOne.txtCountry;
		resultInfo.codCountryAlpha3 = sourceOne.codCountryAlpha3;
		
		return resultInfo;
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
