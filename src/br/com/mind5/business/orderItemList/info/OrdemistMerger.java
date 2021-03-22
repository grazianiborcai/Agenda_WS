package br.com.mind5.business.orderItemList.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class OrdemistMerger {
	public static List<OrdemistInfo> mergeWithMatlis(List<OrdemistInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeMatlis());
		InfoMerger<OrdemistInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemistInfo> mergeWithOrdemarch(List<OrdemistInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, OrdemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeOrdemarch());
		InfoMerger<OrdemistInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemistInfo> mergeWithOrdist(List<OrdemistInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeOrdist());
		InfoMerger<OrdemistInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemistInfo> mergeToSelect(List<OrdemistInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, OrdemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeToSelect());
		InfoMerger<OrdemistInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
