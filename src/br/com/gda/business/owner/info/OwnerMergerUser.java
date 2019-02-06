package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerUser extends InfoMerger<OwnerInfo, UserInfo, OwnerInfo> {
	public OwnerInfo merge(UserInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergeUser());
	}
	
	
	
	public List<OwnerInfo> merge(List<UserInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergeUser());
	}
}
