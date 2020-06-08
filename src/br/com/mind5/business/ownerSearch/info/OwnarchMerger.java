package br.com.mind5.business.ownerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class OwnarchMerger {
	public static List<OwnarchInfo> mergeToSelect(List<OwnarchInfo> baseInfos, List<OwnarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnarchInfo, OwnarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnarchVisiMergeToSelect());
		InfoMergerV3<OwnarchInfo, OwnarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
