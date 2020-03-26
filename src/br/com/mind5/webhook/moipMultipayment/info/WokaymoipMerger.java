package br.com.mind5.webhook.moipMultipayment.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;

public final class WokaymoipMerger {	
	public static List<WokaymoipInfo> mergeWithDaemon(List<WokaymoipInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<WokaymoipInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WokaymoipVisiMergeDaemon());
		InfoMergerV3<WokaymoipInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
