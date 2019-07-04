package br.com.gda.payment.payOrder.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static PayordInfo mergeWithAddress(AddressInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, AddressInfo> merger = new PayordMergerAddress_();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, AddressInfo> merger = new PayordMergerAddress_();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithPhone(PhoneInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PhoneInfo> merger = new PayordMergerPhone_();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PhoneInfo> merger = new PayordMergerPhone_();		
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
	
	
	
	public static PayordInfo mergeToDelete(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToDelete_();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToDelete(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToDelete_();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
