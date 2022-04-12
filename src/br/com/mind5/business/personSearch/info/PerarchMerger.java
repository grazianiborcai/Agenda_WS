package br.com.mind5.business.personSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PerarchMerger {
	public static List<PerarchInfo> mergeToSelect(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilder<PerarchInfo, PerarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerarchMergerVisiToSelect());
		InfoMerger<PerarchInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
