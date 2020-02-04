package br.com.mind5.security.userAuthentication.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UauthMerger {
	public static UauthInfo mergeWithUselis(UselisInfo sourceOne, UauthInfo sourceTwo) {
		InfoMerger_<UauthInfo, UselisInfo> merger = new UauthMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UauthInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<UauthInfo> sourceTwos) {
		InfoMerger_<UauthInfo, UselisInfo> merger = new UauthMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
