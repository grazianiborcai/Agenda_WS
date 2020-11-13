package br.com.mind5.payment.payOrderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PayordarchMerger {		
	public static List<PayordarchInfo> mergeToSelect(List<PayordarchInfo> baseInfos, List<PayordarchInfo> selectedInfos) {
		InfoMergerBuilder<PayordarchInfo, PayordarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordarchVisiMergeToSelect());
		InfoMerger<PayordarchInfo, PayordarchInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
