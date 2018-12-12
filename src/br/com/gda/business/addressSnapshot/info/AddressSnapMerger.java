package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoWritterFactory;

public final class AddressSnapMerger extends InfoWritterFactory<AddressSnapInfo> {	
	
	public AddressSnapMerger() {
		super(new AddressSnapUniquifier());
	}
	
	
	
	static public AddressSnapInfo merge(FormAddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		return new AddressSnapMergerForm().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public AddressSnapInfo merge(SnapInfo sourceOne, AddressSnapInfo sourceTwo) {
		return new AddressSnapMergerSnap().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public AddressSnapInfo merge(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		return new AddressSnapMergerAddress().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<AddressSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof FormAddressInfo 	&&
			sourceTwos.get(0) instanceof AddressSnapInfo		)
			return new AddressSnapMergerForm().merge((List<FormAddressInfo>) sourceOnes, (List<AddressSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof SnapInfo 	&&
			sourceTwos.get(0) instanceof AddressSnapInfo		)
			return new AddressSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<AddressSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof AddressSnapInfo		)
			return new AddressSnapMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<AddressSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
