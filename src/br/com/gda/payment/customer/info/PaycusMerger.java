package br.com.gda.payment.customer.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class PaycusMerger {		
	public static PaycusInfo mergeWithUsername(UsernameInfo sourceOne, PaycusInfo sourceTwo) {
		InfoMerger<PaycusInfo, UsernameInfo> merger = new PaycusMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaycusInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PaycusInfo> sourceTwos) {
		InfoMerger<PaycusInfo, UsernameInfo> merger = new PaycusMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static PaycusInfo mergeWithUser(UserInfo sourceOne, PaycusInfo sourceTwo) {
		InfoMerger<PaycusInfo, UserInfo> merger = new PaycusMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaycusInfo> mergeWithUser(List<UserInfo> sourceOnes, List<PaycusInfo> sourceTwos) {
		InfoMerger<PaycusInfo, UserInfo> merger = new PaycusMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaycusInfo mergeToSelect(PaycusInfo sourceOne, PaycusInfo sourceTwo) {
		InfoMerger<PaycusInfo, PaycusInfo> merger = new PaycusMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaycusInfo> mergeToSelect(List<PaycusInfo> sourceOnes, List<PaycusInfo> sourceTwos) {
		InfoMerger<PaycusInfo, PaycusInfo> merger = new PaycusMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
