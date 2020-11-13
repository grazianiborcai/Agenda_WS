package br.com.mind5.webhook.moipRefund.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;

public final class WokefumoipMerger {	
	public static List<WokefumoipInfo> mergeWithDaemon(List<WokefumoipInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<WokefumoipInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WokefumoipVisiMergeDaemon());
		InfoMerger<WokefumoipInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
