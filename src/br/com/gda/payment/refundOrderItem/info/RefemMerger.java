package br.com.gda.payment.refundOrderItem.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class RefemMerger {
	public static RefemInfo mergeWithRefumoip(RefumoipInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger<RefemInfo, RefumoipInfo> merger = new RefemMergerRefumoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithRefumoip(List<RefumoipInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger<RefemInfo, RefumoipInfo> merger = new RefemMergerRefumoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefemInfo mergeWithPayord(PayordInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger<RefemInfo, PayordInfo> merger = new RefemMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger<RefemInfo, PayordInfo> merger = new RefemMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefemInfo mergeWithCuspar(CusparInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger<RefemInfo, CusparInfo> merger = new RefemMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger<RefemInfo, CusparInfo> merger = new RefemMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
