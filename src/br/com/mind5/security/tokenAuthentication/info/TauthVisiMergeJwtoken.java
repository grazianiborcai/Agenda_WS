package br.com.mind5.security.tokenAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

final class TauthVisiMergeJwtoken implements InfoMergerVisitorV3<TauthInfo, JwtokenInfo> {
	
	@Override public List<TauthInfo> beforeMerge(List<TauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(TauthInfo baseInfo, JwtokenInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<TauthInfo> merge(TauthInfo baseInfo, JwtokenInfo selectedInfo) {
		List<TauthInfo> results = new ArrayList<>();
		
		baseInfo.codOwner = selectedInfo.codOwner;
		baseInfo.username = selectedInfo.username;
		baseInfo.codPlatform = selectedInfo.codPlatform;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<TauthInfo> getUniquifier() {
		return null;
	}
}
