package br.com.mind5.payment.payOrderItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PayormarchMerger {
	public static List<PayormarchInfo> mergeToSelect(List<PayormarchInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilder<PayormarchInfo, PayormarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayormarchVisiMergeToSelect());
		InfoMerger<PayormarchInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
