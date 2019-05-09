package br.com.gda.security.tokenAuthentication.info;

import java.util.List;


import br.com.gda.info.InfoMerger;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class TauthMerger {
	public static TauthInfo mergeWithJwtoken(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		InfoMerger<TauthInfo, JwtokenInfo> merger = new TauthMergerJwtoken();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TauthInfo> mergeWithJwtoken(List<JwtokenInfo> sourceOnes, List<TauthInfo> sourceTwos) {
		InfoMerger<TauthInfo, JwtokenInfo> merger = new TauthMergerJwtoken();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static TauthInfo mergeWithUsername(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		InfoMerger<TauthInfo, UsernameInfo> merger = new TauthMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TauthInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<TauthInfo> sourceTwos) {
		InfoMerger<TauthInfo, UsernameInfo> merger = new TauthMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
