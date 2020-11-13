package br.com.mind5.business.orderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class OrdarchMerger {	
	public static List<OrdarchInfo> mergeToSelect(List<OrdarchInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilder<OrdarchInfo, OrdarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdarchVisiMergeToSelect());
		InfoMerger<OrdarchInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
