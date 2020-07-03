package br.com.mind5.business.customerSnapshot.info;


import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusnapMerger {
	public static List<CusnapInfo> mergeWithUselis(List<CusnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<CusnapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergeUselis());
		InfoMergerV3<CusnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusnapInfo> mergeWithPerson(List<CusnapInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<CusnapInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergePerson());
		InfoMergerV3<CusnapInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusnapInfo> mergeToSelect(List<CusnapInfo> baseInfos, List<CusnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CusnapInfo, CusnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergeToSelect());
		InfoMergerV3<CusnapInfo, CusnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
