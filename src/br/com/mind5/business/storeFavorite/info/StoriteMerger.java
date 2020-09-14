package br.com.mind5.business.storeFavorite.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoriteMerger {
	public static List<StoriteInfo> mergeWithUsername(List<StoriteInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StoriteInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeUsername());
		InfoMergerV3<StoriteInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoriteInfo> mergeToSelect(List<StoriteInfo> baseInfos, List<StoriteInfo> selectedInfos) {
		InfoMergerBuilderV3<StoriteInfo, StoriteInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeToSelect());
		InfoMergerV3<StoriteInfo, StoriteInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
