package br.com.mind5.authorization.storePartitionAuthorization.info;


import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SytotauhMerger {
	public static List<SytotauhInfo> mergeWithStorauth(List<SytotauhInfo> baseInfos, List<StorauthInfo> selectedInfos) {
		InfoMergerBuilderV3<SytotauhInfo, StorauthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SytotauhVisiMergeStorauth());
		InfoMergerV3<SytotauhInfo, StorauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
