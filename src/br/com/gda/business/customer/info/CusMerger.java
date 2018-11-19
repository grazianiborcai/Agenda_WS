package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoWritterFactory;

public final class CusMerger extends InfoWritterFactory<CusInfo> {	
	
	public CusMerger() {
		super(new CusUniquifier());
	}
	
	
	
	static public CusInfo merge(AddressInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CusInfo merge(GenderInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerGender().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CusInfo merge(PhoneInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<CusInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof GenderInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerGender().merge((List<GenderInfo>) sourceOnes, (List<CusInfo>) sourceTwos);		
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		return null;
	}
}
