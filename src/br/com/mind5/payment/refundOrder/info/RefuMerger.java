package br.com.mind5.payment.refundOrder.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class RefuMerger {
	public static RefuInfo mergeWithPayord(PayordInfo sourceOne, RefuInfo sourceTwo) {
		InfoMerger_<RefuInfo, PayordInfo> merger = new RefuMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefuInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<RefuInfo> sourceTwos) {
		InfoMerger_<RefuInfo, PayordInfo> merger = new RefuMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
