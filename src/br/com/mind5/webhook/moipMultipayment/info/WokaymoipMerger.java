package br.com.mind5.webhook.moipMultipayment.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;

public final class WokaymoipMerger {	
	public static List<WokaymoipInfo> mergeWithDaemon(List<WokaymoipInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<WokaymoipInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WokaymoipMergerVisiDaemon());
		InfoMerger<WokaymoipInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
