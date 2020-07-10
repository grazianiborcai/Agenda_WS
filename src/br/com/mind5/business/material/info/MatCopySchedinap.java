package br.com.mind5.business.material.info;


import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatCopySchedinap extends InfoCopierTemplate<MatInfo, SchedinapInfo> {
	
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
