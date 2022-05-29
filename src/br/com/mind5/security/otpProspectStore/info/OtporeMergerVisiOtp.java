package br.com.mind5.security.otpProspectStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.otp.info.OtpInfo;

final class OtporeMergerVisiOtp extends InfoMergerVisitorTemplate<OtporeInfo, OtpInfo> {

	@Override public boolean shouldMerge(OtporeInfo baseInfo, OtpInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<OtporeInfo> merge(OtporeInfo baseInfo, OtpInfo selectedInfo) {
		List<OtporeInfo> results = new ArrayList<>();

		baseInfo.password = selectedInfo.password;
		baseInfo.hash = selectedInfo.hash;
		baseInfo.salt = selectedInfo.salt;	
		
		results.add(baseInfo);
		return results;
	}
}
