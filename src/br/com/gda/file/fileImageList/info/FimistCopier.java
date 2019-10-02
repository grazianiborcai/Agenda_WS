package br.com.gda.file.fileImageList.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;

public final class FimistCopier {
	public static FimistInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<FimistInfo, OwnerInfo> copier = new FimistCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<FimistInfo, OwnerInfo> copier = new FimistCopyOwner();
		return copier.makeCopy(sources);
	}
}
