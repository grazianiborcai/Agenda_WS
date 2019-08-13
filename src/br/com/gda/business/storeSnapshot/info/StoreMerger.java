package br.com.gda.business.storeSnapshot.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class StoreMerger {
	public static StorapInfo mergeWithAddress(AddressInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithComp(CompInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithComp(List<CompInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithCurrency(CurrencyInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithPerson(PersonInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithPhone(PhoneInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithTimezone(TimezoneInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithUser(UserInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithUser(List<UserInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeWithUsername(UsernameInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorapInfo mergeToSelect(StorapInfo sourceOne, StorapInfo sourceTwo) {
		InfoMerger<StorapInfo, StorapInfo> merger = new StoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorapInfo> mergeToSelect(List<StorapInfo> sourceOnes, List<StorapInfo> sourceTwos) {
		InfoMerger<StorapInfo, StorapInfo> merger = new StoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
