package br.com.mind5.business.ownerList.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class OwnelisMerger {
	public static List<OwnelisInfo> mergeWithBusarea(List<OwnelisInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnelisInfo, BusareaInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeBusarea());
		InfoMergerV3<OwnelisInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeWithComplis(List<OwnelisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnelisInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeComplis());
		InfoMergerV3<OwnelisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeWithOwnarch(List<OwnelisInfo> baseInfos, List<OwnarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnelisInfo, OwnarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeOwnarch());
		InfoMergerV3<OwnelisInfo, OwnarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeToSelect(List<OwnelisInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnelisInfo, OwnelisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeToSelect());
		InfoMergerV3<OwnelisInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
