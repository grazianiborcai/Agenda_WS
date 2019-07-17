package br.com.gda.payment.payOrder.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static PayordInfo mergeWithCrecard(CrecardInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, CrecardInfo> merger = new PayordMergerCrecard();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithCrecard(List<CrecardInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, CrecardInfo> merger = new PayordMergerCrecard();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithSyspar(SysparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, SysparInfo> merger = new PayordMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, SysparInfo> merger = new PayordMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithCuspar(CusparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, CusparInfo> merger = new PayordMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, CusparInfo> merger = new PayordMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithPaypar(PayparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithOrder(OrderInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, OrderInfo> merger = new PayordMergerOrder();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithOrder(List<OrderInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, OrderInfo> merger = new PayordMergerOrder();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithUsername(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeToSelect(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToSelect(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
