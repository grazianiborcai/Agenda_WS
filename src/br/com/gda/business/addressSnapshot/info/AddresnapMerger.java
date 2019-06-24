package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.info.InfoMerger;

public final class AddresnapMerger {	
	public static AddresnapInfo mergeWithForm(FormAddressInfo sourceOne, AddresnapInfo sourceTwo) {
		InfoMerger<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddresnapInfo> mergeWithForm(List<FormAddressInfo> sourceOnes, List<AddresnapInfo> sourceTwos) {
		InfoMerger<AddresnapInfo, FormAddressInfo> merger = new AddresnapMergerForm();		
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
