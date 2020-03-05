package br.com.mind5.business.personSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PerarchMerger {
	public static List<PerarchInfo> mergeToSelect(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PerarchInfo, PerarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerarchVisiMergeToSelect());
		InfoMergerV3<PerarchInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
