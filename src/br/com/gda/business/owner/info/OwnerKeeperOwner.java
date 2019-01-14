package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.info.InfoKeeper;

final class OwnerKeeperOwner extends InfoKeeper<OwnerInfo, OwnerInfo> {
	public OwnerInfo keep(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiKeepOwner());
	}
	
	
	
	public List<OwnerInfo> keep(List<OwnerInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiKeepOwner());
	}
}
