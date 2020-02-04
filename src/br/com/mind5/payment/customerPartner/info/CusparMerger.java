package br.com.mind5.payment.customerPartner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusparMerger {		
	public static CusparInfo mergeWithPhone(PhoneInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, PhoneInfo> merger = new CusparMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, PhoneInfo> merger = new CusparMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CusparInfo mergeWithAddress(AddressInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, AddressInfo> merger = new CusparMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, AddressInfo> merger = new CusparMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeWithCusmoip(CusmoipInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, CusmoipInfo> merger = new CusparMergerCusmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithCusmoip(List<CusmoipInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, CusmoipInfo> merger = new CusparMergerCusmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeWithAddresnap(AddresnapInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, AddresnapInfo> merger = new CusparMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, AddresnapInfo> merger = new CusparMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CusparInfo mergeWithPhonap(PhonapInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, PhonapInfo> merger = new CusparMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, PhonapInfo> merger = new CusparMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeWithSetupar(SetuparInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, SetuparInfo> merger = new CusparMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, SetuparInfo> merger = new CusparMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeWithUserap(UserapInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, UserapInfo> merger = new CusparMergerUserap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithUserap(List<UserapInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, UserapInfo> merger = new CusparMergerUserap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeWithUsername(UsernameInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, UsernameInfo> merger = new CusparMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, UsernameInfo> merger = new CusparMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CusparInfo mergeWithUser(UserInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, UserInfo> merger = new CusparMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeWithUser(List<UserInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, UserInfo> merger = new CusparMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusparInfo mergeToSelect(CusparInfo sourceOne, CusparInfo sourceTwo) {
		InfoMerger_<CusparInfo, CusparInfo> merger = new CusparMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusparInfo> mergeToSelect(List<CusparInfo> sourceOnes, List<CusparInfo> sourceTwos) {
		InfoMerger_<CusparInfo, CusparInfo> merger = new CusparMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
