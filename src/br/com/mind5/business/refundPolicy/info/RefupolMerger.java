package br.com.mind5.business.refundPolicy.info;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class RefupolMerger {
	public static List<RefupolInfo> mergeWithRefupore(List<RefupolInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupolInfo, RefuporeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupolVisiMergeRefupore());
		InfoMergerV3<RefupolInfo, RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefupolInfo> mergeWithOrderem(List<RefupolInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupolInfo, OrderemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupolVisiMergeOrderem());
		InfoMergerV3<RefupolInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
