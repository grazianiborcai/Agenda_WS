package br.com.mind5.config.sysConfig.info;

import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SysonfigMerger {	
	public static List<SysonfigInfo> mergeWithSytotin(List<SysonfigInfo> baseInfos, List<SytotinInfo> selectedInfos) {
		InfoMergerBuilderV3<SysonfigInfo, SytotinInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigVisiMergeSytotin());
		InfoMergerV3<SysonfigInfo, SytotinInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeToSelect(List<SysonfigInfo> baseInfos, List<SysonfigInfo> selectedInfos) {
		InfoMergerBuilderV3<SysonfigInfo, SysonfigInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigVisiMergeToSelect());
		InfoMergerV3<SysonfigInfo, SysonfigInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
