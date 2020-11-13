package br.com.mind5.security.otpUserPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.otp.info.OtpInfo;

final class OtperasVisiMergeOtp implements InfoMergerVisitor<OtperasInfo, OtpInfo> {
	
	@Override public List<OtperasInfo> beforeMerge(List<OtperasInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OtperasInfo> getUniquifier() {
		return null;
	}
}
