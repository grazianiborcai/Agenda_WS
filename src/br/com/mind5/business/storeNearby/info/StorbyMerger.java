package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StorbyMerger {	
	public static List<StorbyInfo> mergeWithStorext(List<StorbyInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, StorextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeStorext());
		InfoMergerV3<StorbyInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithStorite(List<StorbyInfo> baseInfos, List<StoriteInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, StoriteInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeStorite());
		InfoMergerV3<StorbyInfo, StoriteInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithMatopore(List<StorbyInfo> baseInfos, List<MatoporeInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, MatoporeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeMatopore());
		InfoMergerV3<StorbyInfo, MatoporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithFimist(List<StorbyInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeFimist());
		InfoMergerV3<StorbyInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithComplis(List<StorbyInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeComplis());
		InfoMergerV3<StorbyInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithAddress(List<StorbyInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<StorbyInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeAddress());
		InfoMergerV3<StorbyInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
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
