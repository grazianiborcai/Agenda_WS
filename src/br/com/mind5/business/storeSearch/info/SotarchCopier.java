package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.info.InfoCopier;

public final class SotarchCopier {	
	public static SotarchInfo copyFromSchedauth(SchedauthInfo source) {
		InfoCopier<SotarchInfo, SchedauthInfo> copier = new SotarchCopySchedauth();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SotarchInfo> copyFromSchedauth(List<SchedauthInfo> sources) {
		InfoCopier<SotarchInfo, SchedauthInfo> copier = new SotarchCopySchedauth();
		return copier.makeCopy(sources);
	}
}
