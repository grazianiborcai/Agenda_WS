package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class RefugritemMerger {
	public static List<RefugritemInfo> mergeWithRefupo(List<RefugritemInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		InfoMergerBuilder<RefugritemInfo, RefupoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugritemVisiMergeRefupo());
		InfoMerger<RefugritemInfo, RefupoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefugritemInfo> mergeWithRefugritarch(List<RefugritemInfo> baseInfos, List<RefugritarchInfo> selectedInfos) {
		InfoMergerBuilder<RefugritemInfo, RefugritarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugritemVisiMergeRefugritarch());
		InfoMerger<RefugritemInfo, RefugritarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
