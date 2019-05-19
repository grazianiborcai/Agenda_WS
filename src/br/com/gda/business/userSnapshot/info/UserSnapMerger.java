package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class UserSnapMerger extends InfoWritterFactory_<UserSnapInfo> {	
	
	public UserSnapMerger() {
		super(new UserSnapUniquifier());
	}
	
	
	
	static public UserSnapInfo merge(SnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerAddressSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerPersonSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(PersonCusInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerPersonCus().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(PhoneSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerPhoneSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UserSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof SnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerUser().merge((List<UserInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof AddresnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerAddressSnap().merge((List<AddresnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PersonCusInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerPersonCus().merge((List<PersonCusInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PersonSnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerPersonSnap().merge((List<PersonSnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);		
		
		
		if (sourceOnes.get(0) instanceof PhoneSnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerPhoneSnap().merge((List<PhoneSnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
