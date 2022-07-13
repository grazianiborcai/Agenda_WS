package br.com.mind5.file.fileImageDecorated.info;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class FimecoMerger {	
	public static List<FimecoInfo> mergeWithFimist(List<FimecoInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<FimecoInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimecoMergerVisiFimist());
		InfoMerger<FimecoInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
