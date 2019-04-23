package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

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
	
	
	
	static public CusInfo merge(UsernameInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerUsername().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public CusInfo merge(UserInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerUser().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public CusInfo merge(CusInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerToDelete().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public CusInfo merge(CusarchInfo sourceOne, CusInfo sourceTwo) {
		return new CusMergerCusarch().merge(sourceOne, sourceTwo);
	}		
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 		&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<CusInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 			&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 		&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonUserInfo 	&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerPersonUser().merge((List<PersonUserInfo>) sourceOnes, (List<CusInfo>) sourceTwos);		
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 		&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerUser().merge((List<UserInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CusInfo 			&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerToDelete().merge((List<CusInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CusarchInfo 		&&
			sourceTwos.get(0) instanceof CusInfo				)
			return new CusMergerCusarch().merge((List<CusarchInfo>) sourceOnes, (List<CusInfo>) sourceTwos);	
		
		return null;
	}
}
