package br.com.mind5.business.store.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoreMerger {
	public static StoreInfo mergeWithFimist(FimistInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, FimistInfo> merger = new StoreMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, FimistInfo> merger = new StoreMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithSotarch(SotarchInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, SotarchInfo> merger = new StoreMergerSotarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithSotarch(List<SotarchInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, SotarchInfo> merger = new StoreMergerSotarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithAddress(AddressInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, AddressInfo> merger = new StoreMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithStorap(StorapInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, StorapInfo> merger = new StoreMergerStorap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithStorap(List<StorapInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, StorapInfo> merger = new StoreMergerStorap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithComp(CompInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithComp(List<CompInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, CompInfo> merger = new StoreMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithCurrency(CurrencyInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, CurrencyInfo> merger = new StoreMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithPerson(PersonInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, PersonInfo> merger = new StoreMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithPhone(PhoneInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, PhoneInfo> merger = new StoreMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithTimezone(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, TimezoneInfo> merger = new StoreMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithUser(UserInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithUser(List<UserInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, UserInfo> merger = new StoreMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeWithUsername(UsernameInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, UsernameInfo> merger = new StoreMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeToDelete(StoreInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeToDelete(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeToSelect(StoreInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeToSelect(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoreInfo mergeToUpdate(StoreInfo sourceOne, StoreInfo sourceTwo) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoreInfo> mergeToUpdate(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		InfoMerger_<StoreInfo, StoreInfo> merger = new StoreMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
