package br.com.mind5.payment.customerPartnerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CusparchMerger {	
	public static List<CusparchInfo> mergeToSelect(List<CusparchInfo> baseInfos, List<CusparchInfo> selectedInfos) {
		InfoMergerBuilder<CusparchInfo, CusparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparchMergerVisiToSelect());
		InfoMerger<CusparchInfo, CusparchInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
