package br.com.gda.security.tokenAuthentication.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class TauthMergerUsername extends InfoMerger_<TauthInfo, UsernameInfo, TauthInfo> {
	public TauthInfo merge(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new TauthVisiMergeUsername());
	}
	
	
	
	public List<TauthInfo> merge(List<UsernameInfo> sourceOnes, List<TauthInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new TauthVisiMergeUsername());
	}
}
