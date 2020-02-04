package br.com.mind5.security.tokenAuthentication.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class TauthMerger {
	public static TauthInfo mergeWithJwtoken(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		InfoMerger_<TauthInfo, JwtokenInfo> merger = new TauthMergerJwtoken();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TauthInfo> mergeWithJwtoken(List<JwtokenInfo> sourceOnes, List<TauthInfo> sourceTwos) {
		InfoMerger_<TauthInfo, JwtokenInfo> merger = new TauthMergerJwtoken();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static TauthInfo mergeWithUsername(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		InfoMerger_<TauthInfo, UsernameInfo> merger = new TauthMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TauthInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<TauthInfo> sourceTwos) {
		InfoMerger_<TauthInfo, UsernameInfo> merger = new TauthMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
