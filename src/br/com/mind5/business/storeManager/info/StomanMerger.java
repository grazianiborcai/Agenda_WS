package br.com.mind5.business.storeManager.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StomanMerger {	
	public static List<StomanInfo> mergeWithUsername(List<StomanInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StomanInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StomanMergerVisiUsername());
		InfoMerger<StomanInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StomanInfo> mergeToSelect(List<StomanInfo> baseInfos, List<StomanInfo> selectedInfos) {
		InfoMergerBuilder<StomanInfo, StomanInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StomanMergerVisiToSelect());
		InfoMerger<StomanInfo, StomanInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
