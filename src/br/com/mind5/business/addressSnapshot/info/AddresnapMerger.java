package br.com.mind5.business.addressSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class AddresnapMerger {
	public static List<AddresnapInfo> mergeWithCuslis(List<AddresnapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeCuslis());
		InfoMergerV3<AddresnapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithEmplis(List<AddresnapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeEmplis());
		InfoMergerV3<AddresnapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AddresnapInfo> mergeWithUselis(List<AddresnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeUselis());
		InfoMergerV3<AddresnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithFormess(List<AddresnapInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, FormessInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeFormess());
		InfoMergerV3<AddresnapInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCountry(List<AddresnapInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeCountry());
		InfoMergerV3<AddresnapInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithState(List<AddresnapInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, StateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeState());
		InfoMergerV3<AddresnapInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeToSelect(List<AddresnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<AddresnapInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapVisiMergeToSelect());
		InfoMergerV3<AddresnapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
