package br.com.mind5.authorization.storePartitionAuthorization.info;


import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SytotauhMerger {
	public static List<SytotauhInfo> mergeWithStorauth(List<SytotauhInfo> baseInfos, List<StorauthInfo> selectedInfos) {
		InfoMergerBuilder<SytotauhInfo, StorauthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SytotauhVisiMergeStorauth());
		InfoMerger<SytotauhInfo, StorauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
