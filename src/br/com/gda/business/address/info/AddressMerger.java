package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.info.InfoWritterFactory;

public final class AddressMerger extends InfoWritterFactory<AddressInfo> {	
	
	public AddressMerger() {
		super(new AddressUniquifier());
	}
	
	
	
	static public AddressInfo merge(AddressFormInfo sourceOne, AddressInfo sourceTwo) {
		return new AddressMergerAddressForm().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<AddressInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof AddressFormInfo 	&&
			sourceTwos.get(0) instanceof AddressInfo		)
			return new AddressMergerAddressForm().merge((List<AddressFormInfo>) sourceOnes, (List<AddressInfo>) sourceTwos);
		
		return null;
	}
}
