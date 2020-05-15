package br.com.mind5.security.userAuthentication.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UauthMerger {
	public static List<UauthInfo> mergeWithUselis(List<UauthInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<UauthInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UauthVisiMergeUselis());
		InfoMergerV3<UauthInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
