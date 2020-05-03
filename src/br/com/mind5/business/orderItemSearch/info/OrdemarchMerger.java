package br.com.mind5.business.orderItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class OrdemarchMerger {
	public static List<OrdemarchInfo> mergeToSelect(List<OrdemarchInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemarchInfo, OrdemarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemarchVisiMergeToSelect());
		InfoMergerV3<OrdemarchInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
