package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoWritterFactory;

public final class CusMerger extends InfoWritterFactory<CusInfo> {	
	
	public CusMerger() {
		super(new CusUniquifier());
	}
	
	
	
	static public CusInfo merge(AddressInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CusInfo merge(PhoneInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public CusInfo merge(PersonInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public CusInfo merge(PersonUserInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerPersonUser().merge(sourceOne, sourceTwo);
	}		
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<CusInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 		&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonUserInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusMergerPersonUser().merge((List<PersonUserInfo>) sourceOnes, (List<CusInfo>) sourceTwos);		
		
		return null;
	}
}
