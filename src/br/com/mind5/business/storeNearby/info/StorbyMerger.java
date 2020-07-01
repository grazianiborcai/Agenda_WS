package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StorbyMerger {	
	public static List<StorbyInfo> mergeWithGeosh(List<StorbyInfo> baseInfos, List<GeoshInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, GeoshInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeGeosh());
		InfoMergerV3<StorbyInfo, GeoshInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeToSelect(List<StorbyInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, StorbyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeToSelect());
		InfoMergerV3<StorbyInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
