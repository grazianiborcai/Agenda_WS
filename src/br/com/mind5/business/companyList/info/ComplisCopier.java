package br.com.mind5.business.companyList.info;


import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoCopier;

public final class ComplisCopier {
	public static ComplisInfo copyFromOwnerap(OwnerapInfo source) {
		InfoCopier<ComplisInfo, OwnerapInfo> copier = new ComplisCopyOwnerap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<ComplisInfo> copyFromOwnerap(List<OwnerapInfo> sources) {
		InfoCopier<ComplisInfo, OwnerapInfo> copier = new ComplisCopyOwnerap();
		return copier.makeCopy(sources);
	}
}
