package br.com.mind5.business.storeTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StorextsnapMerger {
	public static List<StorextsnapInfo> mergeWithStorext(List<StorextsnapInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextsnapInfo, StorextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextsnapVisiMergeStorext());
		InfoMergerV3<StorextsnapInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	
	public static List<StorextsnapInfo> mergeToSelect(List<StorextsnapInfo> baseInfos, List<StorextsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextsnapInfo, StorextsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextsnapVisiMergeToSelect());
		InfoMergerV3<StorextsnapInfo, StorextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
