package br.com.mind5.business.companySearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class ComparchMerger {	
	public static List<ComparchInfo> mergeToSelect(List<ComparchInfo> baseInfos, List<ComparchInfo> selectedInfos) {
		InfoMergerBuilder<ComparchInfo, ComparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComparchMergerVisiToSelect());
		InfoMerger<ComparchInfo, ComparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
