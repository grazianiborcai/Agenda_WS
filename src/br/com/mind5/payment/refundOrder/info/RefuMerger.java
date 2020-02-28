package br.com.mind5.payment.refundOrder.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class RefuMerger {
	public static List<RefuInfo> mergeWithPayord(List<RefuInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergePayord());
		InfoMergerV3<RefuInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
