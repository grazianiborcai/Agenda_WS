package br.com.mind5.masterData.materialGroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class MatoupMerger {
	public static List<MatoupInfo> mergeWithMatouparch(List<MatoupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		InfoMergerBuilder<MatoupInfo, MatouparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupVisiMergeMatouparch());
		InfoMerger<MatoupInfo, MatouparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupInfo> mergeWithBusarea(List<MatoupInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilder<MatoupInfo, BusareaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupVisiMergeBusarea());
		InfoMerger<MatoupInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
