package br.com.mind5.payment.payOrder.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static PayordInfo mergeWithLatest(PayordarchInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, PayordarchInfo> merger = new PayordMergerLatest();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithLatest(List<PayordarchInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, PayordarchInfo> merger = new PayordMergerLatest();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithMultmoip(MultmoipInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, MultmoipInfo> merger = new PayordMergerMultmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithMultmoip(List<MultmoipInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, MultmoipInfo> merger = new PayordMergerMultmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithPayordem(PayordemInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, PayordemInfo> merger = new PayordMergerPayordem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithPayordem(List<PayordemInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, PayordemInfo> merger = new PayordMergerPayordem();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithCrecard(CrecardInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, CrecardInfo> merger = new PayordMergerCrecard();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithCrecard(List<CrecardInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, CrecardInfo> merger = new PayordMergerCrecard();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithSyspar(SysparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, SysparInfo> merger = new PayordMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, SysparInfo> merger = new PayordMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithCuspar(CusparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, CusparInfo> merger = new PayordMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, CusparInfo> merger = new PayordMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithPaypar(PayparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithOrder(OrderInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, OrderInfo> merger = new PayordMergerOrder();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithOrder(List<OrderInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, OrderInfo> merger = new PayordMergerOrder();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithUsername(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeToSelect(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToSelect(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
	
	
	
	public static PayordInfo mergeToUpdate(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger_<PayordInfo, PayordInfo> merger = new PayordMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToUpdate(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger_<PayordInfo, PayordInfo> merger = new PayordMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
