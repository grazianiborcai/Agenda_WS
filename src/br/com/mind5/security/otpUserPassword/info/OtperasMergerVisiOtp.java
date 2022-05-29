package br.com.mind5.security.otpUserPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.otp.info.OtpInfo;

final class OtperasMergerVisiOtp extends InfoMergerVisitorTemplate<OtperasInfo, OtpInfo> {

	@Override public boolean shouldMerge(OtperasInfo baseInfo, OtpInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<OtperasInfo> merge(OtperasInfo baseInfo, OtpInfo selectedInfo) {
		List<OtperasInfo> results = new ArrayList<>();

		baseInfo.password = selectedInfo.password;
		baseInfo.hash = selectedInfo.hash;
		baseInfo.salt = selectedInfo.salt;	
		
		results.add(baseInfo);
		return results;
	}
}
