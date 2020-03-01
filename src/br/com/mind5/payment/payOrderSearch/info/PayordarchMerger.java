package br.com.mind5.payment.payOrderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PayordarchMerger {		
	public static List<PayordarchInfo> mergeToSelect(List<PayordarchInfo> baseInfos, List<PayordarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordarchInfo, PayordarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordarchVisiMergeToSelect());
		InfoMergerV3<PayordarchInfo, PayordarchInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
