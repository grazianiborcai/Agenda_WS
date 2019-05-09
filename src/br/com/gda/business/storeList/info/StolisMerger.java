package br.com.gda.business.storeList.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

public final class StolisMerger {
	public static StolisInfo mergeWithAddress(AddressInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, AddressInfo> merger = new StolisMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, AddressInfo> merger = new StolisMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolisInfo mergeWithComp(CompInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, CompInfo> merger = new StolisMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithComp(List<CompInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, CompInfo> merger = new StolisMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolisInfo mergeWithCurrency(CurrencyInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, CurrencyInfo> merger = new StolisMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, CurrencyInfo> merger = new StolisMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolisInfo mergeWithPhone(PhoneInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, PhoneInfo> merger = new StolisMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, PhoneInfo> merger = new StolisMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolisInfo mergeWithTimezone(TimezoneInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, TimezoneInfo> merger = new StolisMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, TimezoneInfo> merger = new StolisMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolisInfo mergeToSelect(StolisInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, StolisInfo> merger = new StolisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeToSelect(List<StolisInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, StolisInfo> merger = new StolisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
