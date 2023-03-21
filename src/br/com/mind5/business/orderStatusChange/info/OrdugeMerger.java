package br.com.mind5.business.orderStatusChange.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class OrdugeMerger {
	public static List<OrdugeInfo> mergeWithPayordist(List<OrdugeInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<OrdugeInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdugeMergerVisiPayordist());
		InfoMerger<OrdugeInfo,PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
