package br.com.mind5.business.ownerSnapshot.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OwnerapMerger {
	public static List<OwnerapInfo> mergeWithComplis(List<OwnerapInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerapInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeComplis());
		InfoMergerV3<OwnerapInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerapInfo> mergeWithPersolis(List<OwnerapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerapInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergePersolis());
		InfoMergerV3<OwnerapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerapInfo> mergeWithUselis(List<OwnerapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeUselis());
		InfoMergerV3<OwnerapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OwnerapInfo> mergeToSelect(List<OwnerapInfo> baseInfos, List<OwnerapInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerapInfo, OwnerapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerapVisiMergeToSelect());
		InfoMergerV3<OwnerapInfo, OwnerapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
