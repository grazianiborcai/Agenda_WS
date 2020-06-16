package br.com.mind5.message.emailUserOtp.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class EmusotpCopier {	
	public static EmusotpInfo copyFromOtperas(OtperasInfo source) {
		InfoCopier<EmusotpInfo, OtperasInfo> copier = new EmusotpCopyOtperas();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmusotpInfo> copyFromOtperas(List<OtperasInfo> sources) {
		InfoCopier<EmusotpInfo, OtperasInfo> copier = new EmusotpCopyOtperas();
		return copier.makeCopy(sources);
	}
}
