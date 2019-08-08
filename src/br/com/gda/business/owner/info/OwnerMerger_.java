package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class OwnerMerger_ extends InfoWritterFactory_<OwnerInfo> {	
	
	public OwnerMerger_() {
		super(new OwnerUniquifier());
	}
	
	
	
	static public OwnerInfo merge(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OwnerInfo merge(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OwnerInfo merge(PersonInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerPerson().merge(sourceOne, sourceTwo);
	}		
	
	
	
	static public OwnerInfo merge(CompInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerComp().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OwnerInfo merge(UserInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerUser().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OwnerInfo merge(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerOwntore().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OwnerInfo merge(UsernameInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerUsername().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OwnerInfo merge(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<OwnerInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 	&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 		&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CompInfo 		&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerComp().merge((List<CompInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 		&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerUser().merge((List<UserInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof OwntoreInfo	&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerOwntore().merge((List<OwntoreInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo	&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof OwnerInfo		&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerToDelete().merge((List<OwnerInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		return null;
	}
}
