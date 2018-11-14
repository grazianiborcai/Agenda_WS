package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.InfoWritterFactory;

public final class AddressMerger extends InfoWritterFactory<AddressInfo> {	
	
	public AddressMerger() {
		super(new AddressUniquifier());
	}
	
	
	
	static public AddressInfo merge(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		return new AddressMergerForm().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<AddressInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof FormAddressInfo 	&&
			sourceTwos.get(0) instanceof AddressInfo		)
			return new AddressMergerForm().merge((List<FormAddressInfo>) sourceOnes, (List<AddressInfo>) sourceTwos);
		
		return null;
	}
}
