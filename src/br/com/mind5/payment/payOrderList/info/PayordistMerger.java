package br.com.mind5.payment.payOrderList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PayordistMerger {	
	public static List<PayordistInfo> mergeToSelect(List<PayordistInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<PayordistInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordistMergerVisiToSelect());
		InfoMerger<PayordistInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
