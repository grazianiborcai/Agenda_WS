package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;

public final class AddresnapMerger {	
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
