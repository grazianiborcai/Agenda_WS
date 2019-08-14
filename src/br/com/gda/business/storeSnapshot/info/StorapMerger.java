package br.com.gda.business.storeSnapshot.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class StorapMerger {
	public static StorapInfo mergeWithAddresnap(AddresnapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, AddresnapInfo> merger = new StorapMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, AddresnapInfo> merger = new StorapMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithComp(CompInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, CompInfo> merger = new StorapMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithComp(List<CompInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, CompInfo> merger = new StorapMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithCompnap(CompnapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, CompnapInfo> merger = new StorapMergerCompnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithCompnap(List<CompnapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, CompnapInfo> merger = new StorapMergerCompnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithCurrency(CurrencyInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, CurrencyInfo> merger = new StorapMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, CurrencyInfo> merger = new StorapMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithPerson(PersonInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, PersonInfo> merger = new StorapMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, PersonInfo> merger = new StorapMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithPersonap(PersonapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, PersonapInfo> merger = new StorapMergerPersonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithPersonap(List<PersonapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, PersonapInfo> merger = new StorapMergerPersonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithPhonap(PhonapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, PhonapInfo> merger = new StorapMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, PhonapInfo> merger = new StorapMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithTimezone(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, TimezoneInfo> merger = new StorapMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, TimezoneInfo> merger = new StorapMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithUser(UserInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, UserInfo> merger = new StorapMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithUser(List<UserInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, UserInfo> merger = new StorapMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithUserap(UserapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, UserapInfo> merger = new StorapMergerUserap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithUserap(List<UserapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, UserapInfo> merger = new StorapMergerUserap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeToSelect(StorapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, StorapInfo> merger = new StorapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeToSelect(List<StorapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, StorapInfo> merger = new StorapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
