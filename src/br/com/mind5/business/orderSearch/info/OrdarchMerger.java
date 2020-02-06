package br.com.mind5.business.orderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class OrdarchMerger {	
	public static List<OrdarchInfo> mergeToSelect(List<OrdarchInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdarchInfo, OrdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdarchVisiMergeToSelect());
		InfoMergerV3<OrdarchInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
