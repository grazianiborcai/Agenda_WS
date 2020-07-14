package br.com.mind5.business.employeeSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmpnapMerger {
	public static List<EmpnapInfo> mergeWithUselis(List<EmpnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeUselis());
		InfoMergerV3<EmpnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersolis(List<EmpnapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePersolis());
		InfoMergerV3<EmpnapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithAddresnap(List<EmpnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeAddresnap());
		InfoMergerV3<EmpnapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersonap(List<EmpnapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, PersonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePersonap());
		InfoMergerV3<EmpnapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPhonap(List<EmpnapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePhonap());
		InfoMergerV3<EmpnapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeToSelect(List<EmpnapInfo> baseInfos, List<EmpnapInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpnapInfo, EmpnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeToSelect());
		InfoMergerV3<EmpnapInfo, EmpnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
