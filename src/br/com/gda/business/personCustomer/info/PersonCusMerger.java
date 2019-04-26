package br.com.gda.business.personCustomer.info;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class PersonCusMerger extends InfoWritterFactory_<PersonCusInfo> {	
	
	public PersonCusMerger() {
		super();
	}
	
	
	
	static public PersonCusInfo merge(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		return new PersonCusMergerCus().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonCusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof CusInfo 	&&
			sourceTwos.get(0) instanceof PersonCusInfo		)
			return new PersonCusMergerCus().merge((List<CusInfo>) sourceOnes, (List<PersonCusInfo>) sourceTwos);
		
		return null;
	}
}
