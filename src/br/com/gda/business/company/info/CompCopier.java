package br.com.gda.business.company.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;

public final class CompCopier {
	public static CompInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<CompInfo, OwnerInfo> copier = new CompCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CompInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<CompInfo, OwnerInfo> copier = new CompCopyOwner();
		return copier.makeCopy(sources);
	}
}
