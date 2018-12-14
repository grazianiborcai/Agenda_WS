package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory;

public final class UserSnapMerger extends InfoWritterFactory<UserSnapInfo> {	
	
	public UserSnapMerger() {
		super();
	}
	
	
	
	static public UserSnapInfo merge(SnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public UserSnapInfo merge(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return new UserSnapMergerPersonSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UserSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof SnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerUser().merge((List<UserInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PersonSnapInfo 	&&
			sourceTwos.get(0) instanceof UserSnapInfo		)
			return new UserSnapMergerPersonSnap().merge((List<PersonSnapInfo>) sourceOnes, (List<UserSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
