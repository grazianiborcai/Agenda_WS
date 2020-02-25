package br.com.mind5.payment.payOrderItemList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PayordemistMerger {
	public static List<PayordemistInfo> mergeToSelect(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemistInfo, PayordemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemistVisiMergeToSelect());
		InfoMergerV3<PayordemistInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
