package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StorbyMerger {	
	public static List<StorbyInfo> mergeWithSysdistr(List<StorbyInfo> baseInfos, List<SysdistrInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, SysdistrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiSysdistr());
		InfoMerger<StorbyInfo, SysdistrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithStorext(List<StorbyInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiStorext());
		InfoMerger<StorbyInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithStorite(List<StorbyInfo> baseInfos, List<StoriteInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StoriteInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiStorite());
		InfoMerger<StorbyInfo, StoriteInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithMatopore(List<StorbyInfo> baseInfos, List<MatoporeInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, MatoporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiMatopore());
		InfoMerger<StorbyInfo, MatoporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithFimeco(List<StorbyInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, FimecoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiFimeco());
		InfoMerger<StorbyInfo, FimecoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithComplis(List<StorbyInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiComplis());
		InfoMerger<StorbyInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithAddress(List<StorbyInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiAddress());
		InfoMerger<StorbyInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithGeosh(List<StorbyInfo> baseInfos, List<GeoshInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, GeoshInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiGeosh());
		InfoMerger<StorbyInfo, GeoshInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeToSelect(List<StorbyInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StorbyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyMergerVisiToSelect());
		InfoMerger<StorbyInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
