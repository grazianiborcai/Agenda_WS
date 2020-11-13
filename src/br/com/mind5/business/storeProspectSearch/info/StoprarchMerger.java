package br.com.mind5.business.storeProspectSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StoprarchMerger {		
	public static List<StoprarchInfo> mergeToSelect(List<StoprarchInfo> baseInfos, List<StoprarchInfo> selectedInfos) {
		InfoMergerBuilder<StoprarchInfo, StoprarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprarchVisiMergeToSelect());
		InfoMerger<StoprarchInfo, StoprarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
