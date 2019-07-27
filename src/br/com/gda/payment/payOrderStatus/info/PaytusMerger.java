package br.com.gda.payment.payOrderStatus.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;

public final class PaytusMerger {	
	public static PaytusInfo mergeWithPayord(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger<PaytusInfo, PayordInfo> merger = new PaytusMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger<PaytusInfo, PayordInfo> merger = new PaytusMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PaytusInfo mergeWithPaytusem(PaytusemInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger<PaytusInfo, PaytusemInfo> merger = new PaytusMergerPaytusem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaytusem(List<PaytusemInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger<PaytusInfo, PaytusemInfo> merger = new PaytusMergerPaytusem();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaytusInfo mergeWithCuspar(CusparInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger<PaytusInfo, CusparInfo> merger = new PaytusMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger<PaytusInfo, CusparInfo> merger = new PaytusMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaytusInfo mergeWithMultmoip(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger<PaytusInfo, MultmoipInfo> merger = new PaytusMergerMultmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithMultmoip(List<MultmoipInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger<PaytusInfo, MultmoipInfo> merger = new PaytusMergerMultmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
