package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpMerger extends InfoWritterFactory_<EmpInfo> {	
	
	public EmpMerger() {
		super(new EmpUniquifier());
	}
	
	
	
	static public EmpInfo merge(AddressInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public EmpInfo merge(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public EmpInfo merge(PersonInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public EmpInfo merge(UsernameInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerUsername().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public EmpInfo merge(EmpInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerToDelete().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public EmpInfo merge(UserInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerUser().merge(sourceOne, sourceTwo);
	}	

	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 		&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 			&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 		&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 		&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof EmpInfo 			&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerToDelete().merge((List<EmpInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerUser().merge((List<UserInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
			
		
		return null;
	}
}
