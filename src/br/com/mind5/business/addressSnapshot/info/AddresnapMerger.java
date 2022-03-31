package br.com.mind5.business.addressSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class AddresnapMerger {
	public static List<AddresnapInfo> mergeWithAddresnaparch(List<AddresnapInfo> baseInfos, List<AddresnaparchInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, AddresnaparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiAddresnaparch());
		InfoMerger<AddresnapInfo, AddresnaparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithStolis(List<AddresnapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiStolis());
		InfoMerger<AddresnapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCuslis(List<AddresnapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiCuslis());
		InfoMerger<AddresnapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithEmplis(List<AddresnapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiEmplis());
		InfoMerger<AddresnapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AddresnapInfo> mergeWithUselis(List<AddresnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiUselis());
		InfoMerger<AddresnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithFormess(List<AddresnapInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, FormessInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiFormess());
		InfoMerger<AddresnapInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCountry(List<AddresnapInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiCountry());
		InfoMerger<AddresnapInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeWithState(List<AddresnapInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiState());
		InfoMerger<AddresnapInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddresnapInfo> mergeToSelect(List<AddresnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<AddresnapInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnapMergerVisiToSelect());
		InfoMerger<AddresnapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
