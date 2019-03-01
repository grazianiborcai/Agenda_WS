package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class UserMerger extends InfoWritterFactory<UserInfo> {	
	
	public UserMerger() {
		super(new UserUniquifier());
	}
	
	
	
	static public UserInfo merge(AddressInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserInfo merge(PhoneInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public UserInfo merge(PersonInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public UserInfo merge(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerPersonCus().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public UserInfo merge(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerAuthGrRole().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public UserInfo merge(UserInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerToDelete().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public UserInfo merge(UsernameInfo sourceOne, UserInfo sourceTwo) {
		return new UserMergerUsername().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UserInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 		&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 			&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<UserInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 		&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<UserInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonCusInfo 		&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerPersonCus().merge((List<PersonCusInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof AuthGrRoleInfo 	&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerAuthGrRole().merge((List<AuthGrRoleInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerToDelete().merge((List<UserInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 		&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		return null;
	}
}
