package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerPersonUser extends InfoMerger<OwnerInfo, PersonUserInfo, OwnerInfo> {
	public OwnerInfo merge(PersonUserInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergePersonUser());
	}
	
	
	
	public List<OwnerInfo> merge(List<PersonUserInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergePersonUser());
	}
}
