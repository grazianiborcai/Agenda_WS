package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

public final class StolisMerger {
	public static List<StolisInfo> mergeWithStorac(List<StolisInfo> baseInfos, List<StoracInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, StoracInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiStorac());
		InfoMerger<StolisInfo, StoracInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithStorext(List<StolisInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiStorext());
		InfoMerger<StolisInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithSotarch(List<StolisInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiSotarch());
		InfoMerger<StolisInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithFimeco(List<StolisInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, FimecoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiFimeco());
		InfoMerger<StolisInfo, FimecoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithAddress(List<StolisInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiAddress());
		InfoMerger<StolisInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithComplis(List<StolisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiComplis());
		InfoMerger<StolisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithCurrency(List<StolisInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiCurrency());
		InfoMerger<StolisInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithPhone(List<StolisInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiPhone());
		InfoMerger<StolisInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeWithTimezone(List<StolisInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiTimezone());
		InfoMerger<StolisInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolisInfo> mergeToSelect(List<StolisInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StolisInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolisMergerVisiToSelect());
		InfoMerger<StolisInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
