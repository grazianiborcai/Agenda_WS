package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CusarchMerger {	
	public static List<CusarchInfo> mergeToSelect(List<CusarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CusarchInfo, CusarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergeToSelect());
		InfoMergerV3<CusarchInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
