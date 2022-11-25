package br.com.mind5.business.ownerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class OwnarchMerger {
	public static List<OwnarchInfo> mergeWithBusarea(List<OwnarchInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilder<OwnarchInfo, BusareaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnarchMergerVisiBusarea());
		InfoMerger<OwnarchInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnarchInfo> mergeToSelect(List<OwnarchInfo> baseInfos, List<OwnarchInfo> selectedInfos) {
		InfoMergerBuilder<OwnarchInfo, OwnarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnarchMergerVisiToSelect());
		InfoMerger<OwnarchInfo, OwnarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
