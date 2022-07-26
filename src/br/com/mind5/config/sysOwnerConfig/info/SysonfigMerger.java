package br.com.mind5.config.sysOwnerConfig.info;

import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SysonfigMerger {	
	public static List<SysonfigInfo> mergeWithSysdistr(List<SysonfigInfo> baseInfos, List<SysdistrInfo> selectedInfos) {
		InfoMergerBuilder<SysonfigInfo, SysdistrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigMergerVisiSysdistr());
		InfoMerger<SysonfigInfo, SysdistrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeWithSytorbc(List<SysonfigInfo> baseInfos, List<SytorbcInfo> selectedInfos) {
		InfoMergerBuilder<SysonfigInfo, SytorbcInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigMergerVisiSytorbc());
		InfoMerger<SysonfigInfo, SytorbcInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeWithSysotup(List<SysonfigInfo> baseInfos, List<SysotupInfo> selectedInfos) {
		InfoMergerBuilder<SysonfigInfo, SysotupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigMergerVisiSysotup());
		InfoMerger<SysonfigInfo, SysotupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeWithSytotin(List<SysonfigInfo> baseInfos, List<SytotinInfo> selectedInfos) {
		InfoMergerBuilder<SysonfigInfo, SytotinInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigMergerVisiSytotin());
		InfoMerger<SysonfigInfo, SytotinInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SysonfigInfo> mergeToSelect(List<SysonfigInfo> baseInfos, List<SysonfigInfo> selectedInfos) {
		InfoMergerBuilder<SysonfigInfo, SysonfigInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SysonfigMergerVisiToSelect());
		InfoMerger<SysonfigInfo, SysonfigInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
