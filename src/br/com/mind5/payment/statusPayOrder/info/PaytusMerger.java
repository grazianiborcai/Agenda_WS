package br.com.mind5.payment.statusPayOrder.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusMerger {	
	public static PaytusInfo mergeWithPaymoip(PaymoipInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger_<PaytusInfo, PaymoipInfo> merger = new PaytusMergerPaymoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaymoip(List<PaymoipInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger_<PaytusInfo, PaymoipInfo> merger = new PaytusMergerPaymoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PaytusInfo mergeWithPayord(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger_<PaytusInfo, PayordInfo> merger = new PaytusMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger_<PaytusInfo, PayordInfo> merger = new PaytusMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PaytusInfo mergeWithPaytusem(PaytusemInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger_<PaytusInfo, PaytusemInfo> merger = new PaytusMergerPaytusem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaytusem(List<PaytusemInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger_<PaytusInfo, PaytusemInfo> merger = new PaytusMergerPaytusem();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaytusInfo mergeWithCuspar(CusparInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger_<PaytusInfo, CusparInfo> merger = new PaytusMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger_<PaytusInfo, CusparInfo> merger = new PaytusMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaytusInfo mergeWithMultmoip(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
		InfoMerger_<PaytusInfo, MultmoipInfo> merger = new PaytusMergerMultmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusInfo> mergeWithMultmoip(List<MultmoipInfo> sourceOnes, List<PaytusInfo> sourceTwos) {
		InfoMerger_<PaytusInfo, MultmoipInfo> merger = new PaytusMergerMultmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
