package br.com.mind5.business.refundPolicy.info;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class RefupolMerger {
	public static List<RefupolInfo> mergeWithRefupore(List<RefupolInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilder<RefupolInfo, RefuporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupolMergerVisiRefupore());
		InfoMerger<RefupolInfo, RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefupolInfo> mergeWithOrderem(List<RefupolInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<RefupolInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupolMergerVisiOrderem());
		InfoMerger<RefupolInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
