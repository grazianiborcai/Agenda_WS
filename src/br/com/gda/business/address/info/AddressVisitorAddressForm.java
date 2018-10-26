package br.com.gda.business.address.info;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class AddressVisitorAddressForm implements InfoMergerVisitor<AddressInfo, AddressFormInfo, AddressInfo> {

	@Override public AddressInfo writeRecord(AddressFormInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(AddressFormInfo sourceOne, AddressInfo sourceTwo) {
		if (sourceOne.codCountry.equals(sourceTwo.codCountry) == false)
			throw new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private AddressInfo merge(AddressFormInfo sourceOne, AddressInfo sourceTwo) {
		AddressInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codForm = sourceOne.codForm;
		
		return resultInfo;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
