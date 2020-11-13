package br.com.mind5.business.customerSnapshot.info;


import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusnapMerger {
	public static List<CusnapInfo> mergeWithUselis(List<CusnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<CusnapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergeUselis());
		InfoMerger<CusnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusnapInfo> mergeWithPerson(List<CusnapInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<CusnapInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergePerson());
		InfoMerger<CusnapInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusnapInfo> mergeToSelect(List<CusnapInfo> baseInfos, List<CusnapInfo> selectedInfos) {
		InfoMergerBuilder<CusnapInfo, CusnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusnapVisiMergeToSelect());
		InfoMerger<CusnapInfo, CusnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
