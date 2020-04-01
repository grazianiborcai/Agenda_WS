package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapVisiMergeForm implements InfoMergerVisitor_<AddresnapInfo, FormAddressInfo> {

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
		SystemLog.logError(this.getClass(), e);
	}
}
