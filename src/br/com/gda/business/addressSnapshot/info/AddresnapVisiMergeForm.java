package br.com.gda.business.addressSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class AddresnapVisiMergeForm implements InfoMergerVisitor<AddresnapInfo, FormAddressInfo> {

	@Override public AddresnapInfo writeRecord(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo merge(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		AddresnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codForm = sourceOne.codForm;
		
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
	
	
	
	@Override public boolean shouldWrite(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
