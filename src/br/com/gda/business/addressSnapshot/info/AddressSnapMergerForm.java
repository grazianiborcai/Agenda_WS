package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class AddressSnapMergerForm extends InfoMerger_<AddressSnapInfo, FormAddressInfo, AddressSnapInfo> {
	public AddressSnapInfo merge(FormAddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressSnapVisitorForm());
	}
	
	
	
	public List<AddressSnapInfo> merge(List<FormAddressInfo> sourceOnes, List<AddressSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressSnapVisitorForm());
	}
}
