package br.com.mind5.security.userAuthentication.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UauthMerger {
	public static List<UauthInfo> mergeWithUselis(List<UauthInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<UauthInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UauthMergerVisiUselis());
		InfoMerger<UauthInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
