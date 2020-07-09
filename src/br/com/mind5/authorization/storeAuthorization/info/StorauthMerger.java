package br.com.mind5.authorization.storeAuthorization.info;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorauthMerger {
	public static List<StorauthInfo> mergeWithSotarch(List<StorauthInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StorauthInfo, SotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeSotarch());
		InfoMergerV3<StorauthInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorauthInfo> mergeWithUsername(List<StorauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StorauthInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeUsername());
		InfoMergerV3<StorauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorauthInfo> mergeToSelect(List<StorauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {
		InfoMergerBuilderV3<StorauthInfo, StorauthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeToSelect());
		InfoMergerV3<StorauthInfo, StorauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
