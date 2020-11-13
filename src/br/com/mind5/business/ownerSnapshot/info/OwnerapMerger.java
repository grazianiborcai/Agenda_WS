package br.com.mind5.business.ownerSnapshot.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OwnerapMerger {
	public static List<OwnerapInfo> mergeWithComplis(List<OwnerapInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<OwnerapInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeComplis());
		InfoMerger<OwnerapInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerapInfo> mergeWithPersolis(List<OwnerapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<OwnerapInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergePersolis());
		InfoMerger<OwnerapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerapInfo> mergeWithUselis(List<OwnerapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<OwnerapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeUselis());
		InfoMerger<OwnerapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OwnerapInfo> mergeToSelect(List<OwnerapInfo> baseInfos, List<OwnerapInfo> selectedInfos) {
		InfoMergerBuilder<OwnerapInfo, OwnerapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeToSelect());
		InfoMerger<OwnerapInfo, OwnerapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
