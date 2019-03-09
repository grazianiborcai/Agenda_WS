package br.com.gda.business.ownerStore.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;

public final class OwntoreCopier {
	public static OwntoreInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<OwntoreInfo, OwnerInfo> copier = new OwntoreCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OwntoreInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<OwntoreInfo, OwnerInfo> copier = new OwntoreCopyOwner();
		return copier.makeCopy(sources);
	}
}
