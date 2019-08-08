package br.com.gda.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class AddressVisiMergeCountry implements InfoMergerVisitor<AddressInfo, CountryInfo> {

	@Override public AddressInfo writeRecord(CountryInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CountryInfo sourceOne, AddressInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressInfo merge(CountryInfo sourceOne, AddressInfo sourceTwo) {
		AddressInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtCountry = sourceOne.txtCountry;
		resultInfo.codCountryAlpha3 = sourceOne.codCountryAlpha3;
		
		return resultInfo;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CountryInfo sourceOne, AddressInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
