package br.com.mind5.authorization.storeAuthorization.info;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorauthMerger {
	public static List<StorauthInfo> mergeWithSotarch(List<StorauthInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<StorauthInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeSotarch());
		InfoMerger<StorauthInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorauthInfo> mergeWithUsername(List<StorauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StorauthInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeUsername());
		InfoMerger<StorauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorauthInfo> mergeToSelect(List<StorauthInfo> baseInfos, List<StorauthInfo> selectedInfos) {
		InfoMergerBuilder<StorauthInfo, StorauthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorauthVisiMergeToSelect());
		InfoMerger<StorauthInfo, StorauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
