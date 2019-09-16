package br.com.gda.business.personList.info;


import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.info.InfoCopier;

public final class PersolisCopier {
	public static PersolisInfo copyFromOwnerap(OwnerapInfo source) {
		InfoCopier<PersolisInfo, OwnerapInfo> copier = new PersolisCopyOwnerap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersolisInfo> copyFromOwnerap(List<OwnerapInfo> sources) {
		InfoCopier<PersolisInfo, OwnerapInfo> copier = new PersolisCopyOwnerap();
		return copier.makeCopy(sources);
	}
}
