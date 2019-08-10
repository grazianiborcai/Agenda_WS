package br.com.gda.webhook.moipRefund.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;

public final class WokefumoipMerger {	
	public static WokefumoipInfo mergeWithDaemon(UserInfo sourceOne, WokefumoipInfo sourceTwo) {
		InfoMerger<WokefumoipInfo, UserInfo> merger = new WokefumoipMergerDaemon();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<WokefumoipInfo> mergeWithDaemon(List<UserInfo> sourceOnes, List<WokefumoipInfo> sourceTwos) {
		InfoMerger<WokefumoipInfo, UserInfo> merger = new WokefumoipMergerDaemon();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
