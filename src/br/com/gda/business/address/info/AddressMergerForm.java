package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.InfoMerger;

final class AddressMergerForm extends InfoMerger<AddressInfo, FormAddressInfo, AddressInfo> {
	public AddressInfo merge(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressVisitorForm());
	}
	
	
	
	public List<AddressInfo> merge(List<FormAddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressVisitorForm());
	}
}
