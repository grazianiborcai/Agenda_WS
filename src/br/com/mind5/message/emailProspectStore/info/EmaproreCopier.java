package br.com.mind5.message.emailProspectStore.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class EmaproreCopier {	
	public static EmaproreInfo copyFromOtpore(OtporeInfo source) {
		InfoCopier<EmaproreInfo, OtporeInfo> copier = new EmaproreCopyOtpore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmaproreInfo> copyFromOtpore(List<OtporeInfo> sources) {
		InfoCopier<EmaproreInfo, OtporeInfo> copier = new EmaproreCopyOtpore();
		return copier.makeCopy(sources);
	}
}
