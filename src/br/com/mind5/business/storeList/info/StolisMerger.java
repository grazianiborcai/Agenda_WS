package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

public final class StolisMerger {
	public static List<StolisInfo> mergeWithSotarch(List<StolisInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, SotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeSotarch());
		InfoMergerV3<StolisInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithFimist(List<StolisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeFimist());
		InfoMergerV3<StolisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithAddress(List<StolisInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeAddress());
		InfoMergerV3<StolisInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithComplis(List<StolisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeComplis());
		InfoMergerV3<StolisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithCurrency(List<StolisInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeCurrency());
		InfoMergerV3<StolisInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithPhone(List<StolisInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergePhone());
		InfoMergerV3<StolisInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithTimezone(List<StolisInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, TimezoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeTimezone());
		InfoMergerV3<StolisInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeToSelect(List<StolisInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<StolisInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisVisiMergeToSelect());
		InfoMergerV3<StolisInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
