package br.com.mind5.business.storeFavorite.info;

import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoriteMerger {
	public static List<StoriteInfo> mergeWithStolis(List<StoriteInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StoriteInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeStolis());
		InfoMerger<StoriteInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoriteInfo> mergeWithStoritarch(List<StoriteInfo> baseInfos, List<StoritarchInfo> selectedInfos) {
		InfoMergerBuilder<StoriteInfo, StoritarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeStoritarch());
		InfoMerger<StoriteInfo, StoritarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoriteInfo> mergeWithUsername(List<StoriteInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StoriteInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeUsername());
		InfoMerger<StoriteInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoriteInfo> mergeToSelect(List<StoriteInfo> baseInfos, List<StoriteInfo> selectedInfos) {
		InfoMergerBuilder<StoriteInfo, StoriteInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoriteVisiMergeToSelect());
		InfoMerger<StoriteInfo, StoriteInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
