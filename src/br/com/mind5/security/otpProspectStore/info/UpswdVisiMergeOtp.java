package br.com.mind5.security.otpProspectStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.otp.info.OtpInfo;

final class UpswdVisiMergeOtp implements InfoMergerVisitorV3<OtporeInfo, OtpInfo> {
	
	@Override public List<OtporeInfo> beforeMerge(List<OtporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OtporeInfo> getUniquifier() {
		return null;
	}
}
