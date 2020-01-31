package br.com.mind5.business.employeeMaterial.info;


import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatVisiMergeEmpmarch implements InfoMergerVisitor_<EmpmatInfo, EmpmarchInfo> {

	@Override public EmpmatInfo writeRecord(EmpmarchInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return EmpmatInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(EmpmarchInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmpmarchInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
