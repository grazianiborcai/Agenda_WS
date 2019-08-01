package br.com.gda.payment.refundOrder.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class RefuMerger {
	public static RefuInfo mergeWithPayord(PayordInfo sourceOne, RefuInfo sourceTwo) {
		InfoMerger<RefuInfo, PayordInfo> merger = new RefuMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefuInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<RefuInfo> sourceTwos) {
		InfoMerger<RefuInfo, PayordInfo> merger = new RefuMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
