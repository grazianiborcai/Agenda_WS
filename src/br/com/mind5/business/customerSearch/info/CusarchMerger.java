package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CusarchMerger {	
	public static List<CusarchInfo> mergeToSelect(List<CusarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergeToSelect());
		InfoMerger<CusarchInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
