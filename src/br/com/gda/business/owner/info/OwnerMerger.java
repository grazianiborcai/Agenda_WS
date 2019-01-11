package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoWritterFactory;

public final class OwnerMerger extends InfoWritterFactory<OwnerInfo> {	
	
	public OwnerMerger() {
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
	
	
	
	static public OwnerInfo merge(PersonUserInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerPersonUser().merge(sourceOne, sourceTwo);
	}		
	
	
	
	static public OwnerInfo merge(CompInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerMergerComp().merge(sourceOne, sourceTwo);
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
		
		
		if (sourceOnes.get(0) instanceof PersonUserInfo &&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerPersonUser().merge((List<PersonUserInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CompInfo 		&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerMergerComp().merge((List<CompInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);	
		
		return null;
	}
}
