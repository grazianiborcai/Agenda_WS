package br.com.gda.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class AddressVisitorForm implements InfoMergerVisitor<AddressInfo, FormAddressInfo, AddressInfo> {

	@Override public AddressInfo writeRecord(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		if (sourceOne.codCountry.equals(sourceTwo.codCountry) == false) {
			logException(new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH));
			throw new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private AddressInfo merge(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		AddressInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codForm = sourceOne.codForm;
		
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
