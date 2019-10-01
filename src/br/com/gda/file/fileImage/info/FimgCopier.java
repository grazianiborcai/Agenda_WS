package br.com.gda.file.fileImage.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;

public final class FimgCopier {	
	public static FimgInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<FimgInfo, OwnerInfo> copier = new FimgCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimgInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<FimgInfo, OwnerInfo> copier = new FimgCopyOwner();
		return copier.makeCopy(sources);
	}	
}
