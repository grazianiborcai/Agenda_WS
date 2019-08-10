package br.com.gda.webhook.moipMultipayment.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;

public final class WokaymoipMerger {	
	public static WokaymoipInfo mergeWithDaemon(UserInfo sourceOne, WokaymoipInfo sourceTwo) {
		InfoMerger<WokaymoipInfo, UserInfo> merger = new WokaymoipMergerDaemon();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<WokaymoipInfo> mergeWithDaemon(List<UserInfo> sourceOnes, List<WokaymoipInfo> sourceTwos) {
		InfoMerger<WokaymoipInfo, UserInfo> merger = new WokaymoipMergerDaemon();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
