package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.info.InfoMerger;

final class AddressMergerAddressForm extends InfoMerger<AddressInfo, AddressFormInfo, AddressInfo> {
	public AddressInfo merge(AddressFormInfo sourceOne, AddressInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressVisitorAddressForm());
	}
	
	
	
	public List<AddressInfo> merge(List<AddressFormInfo> sourceOnes, List<AddressInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressVisitorAddressForm());
	}
}
