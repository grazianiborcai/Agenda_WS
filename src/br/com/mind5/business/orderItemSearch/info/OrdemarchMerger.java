package br.com.mind5.business.orderItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class OrdemarchMerger {
	public static List<OrdemarchInfo> mergeToSelect(List<OrdemarchInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilder<OrdemarchInfo, OrdemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemarchVisiMergeToSelect());
		InfoMerger<OrdemarchInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
