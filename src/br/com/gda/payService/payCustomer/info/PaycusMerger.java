package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PaycusMerger extends InfoWritterFactory<PaycusInfo> {	
	
	public PaycusMerger() {
		super(new PaycusUniquifier());
	}
	
	
	
	static public PaycusInfo merge(AddressInfo sourceOne, PaycusInfo sourceTwo) {
		return new PaycusMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PaycusInfo merge(PhoneInfo sourceOne, PaycusInfo sourceTwo) {
		return new PaycusMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public PaycusInfo merge(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		return new PaycusMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public PaycusInfo merge(UserInfo sourceOne, PaycusInfo sourceTwo) {
		return new PaycusMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PaycusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof PaycusInfo		)
			return new PaycusMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<PaycusInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 		&&
			sourceTwos.get(0) instanceof PaycusInfo		)
			return new PaycusMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<PaycusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof PaycusInfo		)
			return new PaycusMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<PaycusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof PaycusInfo		)
			return new PaycusMergerUser().merge((List<UserInfo>) sourceOnes, (List<PaycusInfo>) sourceTwos);	
		
		return null;
	}
}
