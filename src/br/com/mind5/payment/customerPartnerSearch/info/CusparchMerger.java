package br.com.mind5.payment.customerPartnerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CusparchMerger {	
	public static List<CusparchInfo> mergeToSelect(List<CusparchInfo> baseInfos, List<CusparchInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparchInfo, CusparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparchVisiMergeToSelect());
		InfoMergerV3<CusparchInfo, CusparchInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
