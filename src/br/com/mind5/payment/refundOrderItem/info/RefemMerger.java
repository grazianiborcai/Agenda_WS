package br.com.mind5.payment.refundOrderItem.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefemMerger {
	public static RefemInfo mergeWithRefumoip(RefumoipInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger_<RefemInfo, RefumoipInfo> merger = new RefemMergerRefumoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithRefumoip(List<RefumoipInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger_<RefemInfo, RefumoipInfo> merger = new RefemMergerRefumoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefemInfo mergeWithPayord(PayordInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger_<RefemInfo, PayordInfo> merger = new RefemMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger_<RefemInfo, PayordInfo> merger = new RefemMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefemInfo mergeWithCuspar(CusparInfo sourceOne, RefemInfo sourceTwo) {
		InfoMerger_<RefemInfo, CusparInfo> merger = new RefemMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefemInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<RefemInfo> sourceTwos) {
		InfoMerger_<RefemInfo, CusparInfo> merger = new RefemMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
