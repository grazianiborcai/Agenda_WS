package br.com.gda.payment.creditCard.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class CrecardMerger {
	public static CrecardInfo mergeWithCremoip(CremoipInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CremoipInfo> merger = new CrecardMergerCremoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithCremoip(List<CremoipInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CremoipInfo> merger = new CrecardMergerCremoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeWithPhone(PhoneInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, PhoneInfo> merger = new CrecardMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, PhoneInfo> merger = new CrecardMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithAddress(AddressInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, AddressInfo> merger = new CrecardMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, AddressInfo> merger = new CrecardMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithCuspar(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithUsername(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeToSelect(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToSelect(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeToDelete(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToDelete(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeToUpdate(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToUpdate(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
