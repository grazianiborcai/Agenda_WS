package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;

public final class AddresnapMerger {	
	public static AddresnapInfo mergeWithStolis(StolisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, StolisInfo> merger = new AddresnapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, StolisInfo> merger = new AddresnapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithCuslis(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, CuslisInfo> merger = new AddresnapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, CuslisInfo> merger = new AddresnapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithEmplis(EmplisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, EmplisInfo> merger = new AddresnapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, EmplisInfo> merger = new AddresnapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AddresnapInfo mergeWithUselis(UselisInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, UselisInfo> merger = new AddresnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, UselisInfo> merger = new AddresnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithForm(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithForm(List<FormAddressInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithCountry(CountryInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, CountryInfo> merger = new AddresnapMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, CountryInfo> merger = new AddresnapMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddresnapInfo mergeWithState(StateInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, StateInfo> merger = new AddresnapMergerState();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithState(List<StateInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, StateInfo> merger = new AddresnapMergerState();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
