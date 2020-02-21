package br.com.mind5.payment.payOrderList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PayordistMerger {	
	public static List<PayordistInfo> mergeToSelect(List<PayordistInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordistInfo, PayordistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordistVisiMergeToSelect());
		InfoMergerV3<PayordistInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
