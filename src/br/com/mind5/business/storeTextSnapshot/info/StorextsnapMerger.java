package br.com.mind5.business.storeTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StorextsnapMerger {
	public static List<StorextsnapInfo> mergeWithStorext(List<StorextsnapInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorextsnapInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextsnapVisiMergeStorext());
		InfoMerger<StorextsnapInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	
	public static List<StorextsnapInfo> mergeToSelect(List<StorextsnapInfo> baseInfos, List<StorextsnapInfo> selectedInfos) {
		InfoMergerBuilder<StorextsnapInfo, StorextsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextsnapVisiMergeToSelect());
		InfoMerger<StorextsnapInfo, StorextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
