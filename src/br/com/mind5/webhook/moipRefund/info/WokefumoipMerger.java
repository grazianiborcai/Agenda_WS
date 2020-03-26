package br.com.mind5.webhook.moipRefund.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;

public final class WokefumoipMerger {	
	public static List<WokefumoipInfo> mergeWithDaemon(List<WokefumoipInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<WokefumoipInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WokefumoipVisiMergeDaemon());
		InfoMergerV3<WokefumoipInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
