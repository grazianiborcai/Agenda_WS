package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SotarchMerger {	
	public static List<SotarchInfo> mergeWithUsername(List<SotarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<SotarchInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchVisiMergeUsername());
		InfoMerger<SotarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SotarchInfo> mergeToSelect(List<SotarchInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<SotarchInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchVisiMergeToSelect());
		InfoMerger<SotarchInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
