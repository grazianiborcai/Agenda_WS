package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerSnap extends InfoMerger_<UserSnapInfo, SnapInfo, UserSnapInfo> {
	public UserSnapInfo merge(SnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<SnapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorSnap());
	}
}
