package br.com.mind5.authorization.customerAuthorization.info;


import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CusauthMerger {
	public static List<CusauthInfo> mergeWithStorauth(List<CusauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {
		InfoMergerBuilderV3<CusauthInfo, StorauthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusauthVisiMergeStorauth());
		InfoMergerV3<CusauthInfo, StorauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
