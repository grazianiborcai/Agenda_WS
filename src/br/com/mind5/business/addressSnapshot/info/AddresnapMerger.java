package br.com.mind5.business.addressSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class AddresnapMerger {	
	public static AddresnapInfo mergeWithStolis(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, StolisInfo> merger = new AddresnapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, StolisInfo> merger = new AddresnapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithCuslis(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, CuslisInfo> merger = new AddresnapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, CuslisInfo> merger = new AddresnapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithEmplis(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, EmplisInfo> merger = new AddresnapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, EmplisInfo> merger = new AddresnapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AddresnapInfo mergeWithUselis(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, UselisInfo> merger = new AddresnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, UselisInfo> merger = new AddresnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithForm(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithForm(List<FormAddressInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithCountry(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, CountryInfo> merger = new AddresnapMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, CountryInfo> merger = new AddresnapMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithState(StateInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, StateInfo> merger = new AddresnapMergerState();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithState(List<StateInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, StateInfo> merger = new AddresnapMergerState();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeToSelect(AddresnapInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger_<AddresnapInfo, AddresnapInfo> merger = new AddresnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeToSelect(List<AddresnapInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger_<AddresnapInfo, AddresnapInfo> merger = new AddresnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
