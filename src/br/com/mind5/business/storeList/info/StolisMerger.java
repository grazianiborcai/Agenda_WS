package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;

public final class StolisMerger {
	public static StolisInfo mergeWithFimist(FimistInfo sourceOne, StolisInfo sourceTwo) {
		InfoMerger<StolisInfo, FimistInfo> merger = new StolisMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolisInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<StolisInfo> sourceTwos) {
		InfoMerger<StolisInfo, FimistInfo> merger = new StolisMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
