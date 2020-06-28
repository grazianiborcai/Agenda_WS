package br.com.mind5.business.companySearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class ComparchMerger {	
	public static List<ComparchInfo> mergeToSelect(List<ComparchInfo> baseInfos, List<ComparchInfo> selectedInfos) {
		InfoMergerBuilderV3<ComparchInfo, ComparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComparchVisiMergeToSelect());
		InfoMergerV3<ComparchInfo, ComparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
