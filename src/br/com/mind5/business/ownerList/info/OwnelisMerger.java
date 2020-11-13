package br.com.mind5.business.ownerList.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class OwnelisMerger {
	public static List<OwnelisInfo> mergeWithFimist(List<OwnelisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<OwnelisInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeFimist());
		InfoMerger<OwnelisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeWithBusarea(List<OwnelisInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilder<OwnelisInfo, BusareaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeBusarea());
		InfoMerger<OwnelisInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeWithComplis(List<OwnelisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<OwnelisInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeComplis());
		InfoMerger<OwnelisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeWithOwnarch(List<OwnelisInfo> baseInfos, List<OwnarchInfo> selectedInfos) {
		InfoMergerBuilder<OwnelisInfo, OwnarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeOwnarch());
		InfoMerger<OwnelisInfo, OwnarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnelisInfo> mergeToSelect(List<OwnelisInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilder<OwnelisInfo, OwnelisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnelisVisiMergeToSelect());
		InfoMerger<OwnelisInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
