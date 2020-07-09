package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SotarchMerger {	
	public static List<SotarchInfo> mergeWithUsername(List<SotarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<SotarchInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchVisiMergeUsername());
		InfoMergerV3<SotarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SotarchInfo> mergeToSelect(List<SotarchInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<SotarchInfo, SotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchVisiMergeToSelect());
		InfoMergerV3<SotarchInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
