package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class StoreMerger {
	public static StoreInfo mergeWithAddress(AddressInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithComp(CompInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithComp(List<CompInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithCurrency(CurrencyInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithPerson(PersonInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithPhone(PhoneInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithTimezone(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithUser(UserInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithUser(List<UserInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithUsername(UsernameInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeToDelete(StoreInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger<StoreInfo, StoreInfo> merger = new StoreMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeToDelete(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger<StoreInfo, StoreInfo> merger = new StoreMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
