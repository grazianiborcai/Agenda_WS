package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StorbyMerger {	
	public static List<StorbyInfo> mergeWithStorext(List<StorbyInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeStorext());
		InfoMerger<StorbyInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithStorite(List<StorbyInfo> baseInfos, List<StoriteInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StoriteInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeStorite());
		InfoMerger<StorbyInfo, StoriteInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithMatopore(List<StorbyInfo> baseInfos, List<MatoporeInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, MatoporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeMatopore());
		InfoMerger<StorbyInfo, MatoporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithFimist(List<StorbyInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeFimist());
		InfoMerger<StorbyInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithComplis(List<StorbyInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeComplis());
		InfoMerger<StorbyInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithAddress(List<StorbyInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeAddress());
		InfoMerger<StorbyInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeWithGeosh(List<StorbyInfo> baseInfos, List<GeoshInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, GeoshInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeGeosh());
		InfoMerger<StorbyInfo, GeoshInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorbyInfo> mergeToSelect(List<StorbyInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilder<StorbyInfo, StorbyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorbyVisiMergeToSelect());
		InfoMerger<StorbyInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
