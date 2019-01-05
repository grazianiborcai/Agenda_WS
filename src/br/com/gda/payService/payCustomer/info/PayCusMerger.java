package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PayCusMerger extends InfoWritterFactory<PayCusInfo> {	
	
	public PayCusMerger() {
		super(new PayCusUniquifier());
	}
	
	
	
	static public PayCusInfo merge(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		return new PayCusMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PayCusInfo merge(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		return new PayCusMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public PayCusInfo merge(PersonInfo sourceOne, PayCusInfo sourceTwo) {
		return new PayCusMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public PayCusInfo merge(UserInfo sourceOne, PayCusInfo sourceTwo) {
		return new PayCusMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayCusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof PayCusInfo		)
			return new PayCusMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<PayCusInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 		&&
			sourceTwos.get(0) instanceof PayCusInfo		)
			return new PayCusMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<PayCusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof PayCusInfo		)
			return new PayCusMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<PayCusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof PayCusInfo		)
			return new PayCusMergerUser().merge((List<UserInfo>) sourceOnes, (List<PayCusInfo>) sourceTwos);	
		
		return null;
	}
}
