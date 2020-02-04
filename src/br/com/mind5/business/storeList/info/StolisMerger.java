package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class StolisMerger {
	public static StolisInfo mergeWithFimist(FimistInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, FimistInfo> merger = new StolisMergerFimist();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithFimist(List<FimistInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, FimistInfo> merger = new StolisMergerFimist();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeWithAddress(AddressInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, AddressInfo> merger = new StolisMergerAddress();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithAddress(List<AddressInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, AddressInfo> merger = new StolisMergerAddress();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeWithComplis(ComplisInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, ComplisInfo> merger = new StolisMergerComplis();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithComplis(List<ComplisInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, ComplisInfo> merger = new StolisMergerComplis();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeWithCurrency(CurrencyInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, CurrencyInfo> merger = new StolisMergerCurrency();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithCurrency(List<CurrencyInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, CurrencyInfo> merger = new StolisMergerCurrency();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeWithPhone(PhoneInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, PhoneInfo> merger = new StolisMergerPhone();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithPhone(List<PhoneInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, PhoneInfo> merger = new StolisMergerPhone();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeWithTimezone(TimezoneInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, TimezoneInfo> merger = new StolisMergerTimezone();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeWithTimezone(List<TimezoneInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, TimezoneInfo> merger = new StolisMergerTimezone();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static StolisInfo mergeToSelect(StolisInfo selectedInfo, StolisInfo baseInfo) {
		InfoMerger_<StolisInfo, StolisInfo> merger = new StolisMergerToSelect();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<StolisInfo> mergeToSelect(List<StolisInfo> selectedInfos, List<StolisInfo> baseInfos) {
		InfoMerger_<StolisInfo, StolisInfo> merger = new StolisMergerToSelect();		
		return merger.merge(selectedInfos, baseInfos);
	}
}
