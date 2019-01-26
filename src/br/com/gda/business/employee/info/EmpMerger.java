package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoWritterFactory;

public final class EmpMerger extends InfoWritterFactory<EmpInfo> {	
	
	public EmpMerger() {
		super(new EmpUniquifier());
	}
	
	
	
	static public EmpInfo merge(AddressInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public EmpInfo merge(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public EmpInfo merge(PersonInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpMergerPerson().merge(sourceOne, sourceTwo);
	}	

	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 		&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 			&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 		&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);	
			
		
		return null;
	}
}
