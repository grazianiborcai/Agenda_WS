package br.com.mind5.payment.payOrderItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PayormarchMerger {
	public static List<PayormarchInfo> mergeToSelect(List<PayormarchInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PayormarchInfo, PayormarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayormarchVisiMergeToSelect());
		InfoMergerV3<PayormarchInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
