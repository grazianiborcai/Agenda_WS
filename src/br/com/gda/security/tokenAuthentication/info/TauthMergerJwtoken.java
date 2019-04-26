package br.com.gda.security.tokenAuthentication.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

final class TauthMergerJwtoken extends InfoMerger_<TauthInfo, JwtokenInfo, TauthInfo> {
	public TauthInfo merge(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new TauthVisiMergeJwtoken());
	}
	
	
	
	public List<TauthInfo> merge(List<JwtokenInfo> sourceOnes, List<TauthInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new TauthVisiMergeJwtoken());
	}
}
