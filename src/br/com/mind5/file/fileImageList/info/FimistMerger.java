package br.com.mind5.file.fileImageList.info;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FimistMerger {	
	public static List<FimistInfo> mergeWithFimarch(List<FimistInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilder<FimistInfo, FimarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimistVisiMergeFimarch());
		InfoMerger<FimistInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimistInfo> mergeToSelect(List<FimistInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<FimistInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimistVisiMergeToSelect());
		InfoMerger<FimistInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
