package br.com.mind5.config.sysOwnerConfig.info;

import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SysonfigMerger {	
	public static List<SysonfigInfo> mergeWithSytorbc(List<SysonfigInfo> baseInfos, List<SytorbcInfo> selectedInfos) {
		InfoMergerBuilderV3<SysonfigInfo, SytorbcInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigVisiMergeSytorbc());
		InfoMergerV3<SysonfigInfo, SytorbcInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeWithSysotup(List<SysonfigInfo> baseInfos, List<SysotupInfo> selectedInfos) {
		InfoMergerBuilderV3<SysonfigInfo, SysotupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigVisiMergeSysotup());
		InfoMergerV3<SysonfigInfo, SysotupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
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
