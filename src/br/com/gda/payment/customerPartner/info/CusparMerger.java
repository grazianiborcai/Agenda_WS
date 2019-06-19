package br.com.gda.payment.customerPartner.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CusparMerger {		
	public static CusparInfo mergeWithUsername(UsernameInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger<CusparInfo, UsernameInfo> merger = new CusparMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger<CusparInfo, UsernameInfo> merger = new CusparMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CusparInfo mergeWithUser(UserInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger<CusparInfo, UserInfo> merger = new CusparMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithUser(List<UserInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger<CusparInfo, UserInfo> merger = new CusparMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeToSelect(CusparInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger<CusparInfo, CusparInfo> merger = new CusparMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeToSelect(List<CusparInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger<CusparInfo, CusparInfo> merger = new CusparMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
