package br.com.gda.business.material.info;


import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatCopySchedinap extends InfoCopierTemplate<MatInfo, SchedinapInfo>{
	
	public MatCopySchedinap() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(SchedinapInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
