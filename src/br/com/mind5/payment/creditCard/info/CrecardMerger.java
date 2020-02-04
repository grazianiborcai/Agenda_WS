package br.com.mind5.payment.creditCard.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CrecardMerger {
	public static CrecardInfo mergeWithCremoip(CremoipInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, CremoipInfo> merger = new CrecardMergerCremoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithCremoip(List<CremoipInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, CremoipInfo> merger = new CrecardMergerCremoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeWithPhone(PhoneInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, PhoneInfo> merger = new CrecardMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, PhoneInfo> merger = new CrecardMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithAddress(AddressInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, AddressInfo> merger = new CrecardMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, AddressInfo> merger = new CrecardMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithCuspar(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeWithUsername(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeToSelect(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToSelect(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeToDelete(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToDelete(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeToUpdate(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToUpdate(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger_<CrecardInfo, CrecardInfo> merger = new CrecardMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
