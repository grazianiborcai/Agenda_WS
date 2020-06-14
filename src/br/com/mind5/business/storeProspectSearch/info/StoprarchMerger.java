package br.com.mind5.business.storeProspectSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StoprarchMerger {		
	public static List<StoprarchInfo> mergeToSelect(List<StoprarchInfo> baseInfos, List<StoprarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoprarchInfo, StoprarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprarchVisiMergeToSelect());
		InfoMergerV3<StoprarchInfo, StoprarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
