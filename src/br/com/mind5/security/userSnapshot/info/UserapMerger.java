package br.com.mind5.security.userSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMerger;

public final class UserapMerger {		
	public static UserapInfo mergeWithAddresnap(AddresnapInfo sourceOne, UserapInfo sourceTwo) {
		InfoMerger<UserapInfo, AddresnapInfo> merger = new UserapMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserapInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<UserapInfo> sourceTwos) {
		InfoMerger<UserapInfo, AddresnapInfo> merger = new UserapMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserapInfo mergeWithPersonap(PersonapInfo sourceOne, UserapInfo sourceTwo) {
		InfoMerger<UserapInfo, PersonapInfo> merger = new UserapMergerPersonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserapInfo> mergeWithPersonap(List<PersonapInfo> sourceOnes, List<UserapInfo> sourceTwos) {
		InfoMerger<UserapInfo, PersonapInfo> merger = new UserapMergerPersonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserapInfo mergeWithPhonap(PhonapInfo sourceOne, UserapInfo sourceTwo) {
		InfoMerger<UserapInfo, PhonapInfo> merger = new UserapMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserapInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<UserapInfo> sourceTwos) {
		InfoMerger<UserapInfo, PhonapInfo> merger = new UserapMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserapInfo mergeToSelect(UserapInfo sourceOne, UserapInfo sourceTwo) {
		InfoMerger<UserapInfo, UserapInfo> merger = new UserapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserapInfo> mergeToSelect(List<UserapInfo> sourceOnes, List<UserapInfo> sourceTwos) {
		InfoMerger<UserapInfo, UserapInfo> merger = new UserapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
